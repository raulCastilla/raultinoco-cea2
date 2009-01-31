package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrearLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Genero> genero=(List<Genero>)request.getSession().getServletContext().getAttribute(AtributosConstantes.generos.toString());
		List<Libro> libro=(List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		List<Autor> autor=(List<Autor>)request.getSession().getServletContext().getAttribute(AtributosConstantes.autores.toString());
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HtmlUtilities html = new HtmlUtilities("A–adir libro");
		pw.println(html.head);
		pw.println(html.cuerpo);
		
		if(request.getParameter("crear")!=null){
			Autor aut = new Autor(request.getParameter("autor"));
			Genero gen = new Genero(request.getParameter("genero"));
			Libro lib= new Libro(request.getParameter("referencia"),request.getParameter("titulo"),gen,aut,Integer.parseInt(request.getParameter("date")),Integer.parseInt(request.getParameter("month")),Integer.parseInt(request.getParameter("year")));
			
			/*genero.add(gen);
			autor.add(aut);*/
			libro.add(lib);
			if(!genero.contains(gen)){ 
				gen.libros.add(lib);
				genero.add(gen);
			}
			else{
				Genero g=null;
				for(Genero tmp:genero) if(tmp.nombre.equals(request.getParameter("genero"))) g=tmp;
				g.libros.add(lib);
			}
			if(!autor.contains(aut)){ 
				aut.libros.add(lib);
				autor.add(aut);
			}
			else{
				Autor a=null;
				for(Autor tmp:autor) if(tmp.nombre.equals(request.getParameter("autor"))) a=tmp;
				a.libros.add(lib);
			}
			pw.println("LIBRO CREADO<br>");
			pw.println("<a href='./crear'>Crear otro</a>");
		}
		else{
			pw.println("<form action='./crear?crear=true' method='post'>"+
					"<table>"+
					"<tr><td>REFERENCIA:</td><td><input type='text' name='referencia' /></td></tr>"+
					"<tr><td>TITULO:</td><td><input type='text' name='titulo' /></td></tr>"+
					"<tr><td>AUTOR:</td><td><input type='text' name='autor' /></td></tr>"+
					"<tr><td>GENERO</td><td><input type='text' name='genero' /></td></tr>"+
					"<tr><td>FECHA</td><td><input type='text' name='fecha' /></td></tr>"+
					"<tr><td><input type='submit' value='Crear' /></td><td></td></tr>"+
					"</table></form>");
		}
		pw.println(html.fin);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
