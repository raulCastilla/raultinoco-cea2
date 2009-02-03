package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarLibrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> libros=(List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuAdmin);
		pw.println("<h3 style='color: #FF0000'>GESTIONAR LIBROS</h3>");
		
		
		if(request.getParameter("genero")!=null){
			Collections.sort(libros,new ComparatorGenero());
		}
		else if(request.getParameter("autor")!=null){
			Collections.sort(libros, new ComparatorAutor());
		}
		else{
			Collections.sort(libros);
		}
		
		
		if(request.getParameter("editar")!=null){
			Libro lib=null;
			for(Libro tmp:libros){
				if(tmp.referencia.equals(request.getParameter("ref"))){
					lib=tmp;
					String consoleOut=lib.titulo;
					lib.referencia=request.getParameter("referencia");
					lib.titulo=request.getParameter("titulo");
					lib.genero.nombre=request.getParameter("genero");
					lib.autor.nombre=request.getParameter("autor");
					lib.fechaPublicacion.set(Calendar.DATE, Integer.parseInt(request.getParameter("date")));
					lib.fechaPublicacion.set(Calendar.MONTH, (Integer.parseInt(request.getParameter("month"))-1));
					lib.fechaPublicacion.set(Calendar.YEAR, Integer.parseInt(request.getParameter("year")));
					System.out.println("Se ha editado el titulo: "+consoleOut);
					//pw.println("Se ha editado el libro: "+consoleOut+"<br>");
					//pw.println("<a href='./editarlibro'>Volver</a>");
					response.sendRedirect("/biblioteca/admin/editarlibro");
					//request.getRequestDispatcher("/editarlibro").forward(request, response);
				}
			}
			
			//request.getRequestDispatcher("/editarlibro").forward(request, response);
		
			
		}
		else if(request.getParameter("eliminar")!=null){
			for(int i=0;i<libros.size();i++){
				if(libros.get(i).referencia.equals(request.getParameter("referencia"))){
					String consoleOut=libros.get(i).titulo;
					libros.remove(i);
					System.out.println("Se ha eliminado el titulo: "+consoleOut);
					//request.getRequestDispatcher("/editarlibro").forward(request, response);
					//pw.println("Se ha eliminado el libro: "+consoleOut+"<br>");
					//pw.println("<a href='./editarlibro'>Volver</a>");
					response.sendRedirect("/biblioteca/admin/editarlibro");
				}
			}
			//
		}
		else if(request.getParameter("referencia")!=null){
			Libro lib=null;
			for(Libro tmp:libros){
				if(tmp.referencia.equals(request.getParameter("referencia"))) lib=tmp;
			}
			pw.println("<form action='./editarlibro?editar=true&ref="+lib.referencia+"' method='post'>"+
					"<table>"+
				"<tr><td>REFERENCIA:</td><td><input type='text' name='referencia' value='"+lib.referencia+"' /></td></tr>"+
				"<tr><td>TÍTULO:</td><td><input type='text' name='titulo' value='"+lib.titulo+"' /></td></tr>"+
				"<tr><td>AUTOR:</td><td><input type='text' name='autor' value='"+lib.autor.nombre+"' /></td></tr>"+
				"<tr><td>GÉNERO</td><td><input type='text' name='genero' value='"+lib.genero.nombre+"'/></td></tr>"+
				"<tr><td>DÍA</td><td><input type='text' name='date' value='"+lib.fechaPublicacion.get(Calendar.DATE)+"' /></td></tr>"+
				"<tr><td>MES</td><td><input type='text' name='month' value='"+(lib.fechaPublicacion.get(Calendar.MONTH)+1)+"' /></td></tr>"+
				"<tr><td>AÑO</td><td><input type='text' name='year' value='"+lib.fechaPublicacion.get(Calendar.YEAR)+"' /></td></tr>"+
				"<tr><td><input type='submit' value='Editar' /></td><td></td></tr>"+
				"</table></form>");
		}
		else{
			pw.println("<a href='./editarlibro?genero=true'>Ordenar por genero</a>/<a href='./editarlibro?autor=true'>Ordenar por autor</a>/<a href='./crear'>Crear libro</a><br>");
		pw.println("<table border='1'>");
		pw.println("<tr><td>REFERENCIA</td><td>T&Iacute;TULO</td><td>G&Eacute;NERO</td><td>AUTOR</td><td>FECHA PUBLICACI&Oacute;N</td><td>ACCIONES</td></tr>");
		for(Libro tmp : libros){
			if(tmp!=null){
				
			pw.println("<tr><td>"+tmp.referencia+"</td><td>"+tmp.titulo+"</td><td>"+tmp.genero+"</td><td>"
						+tmp.autor+"</td><td>"+tmp.fechaPublicacion.get(Calendar.DATE)
						+"/"+(tmp.fechaPublicacion.get(Calendar.MONTH)+1)+"/"
						+tmp.fechaPublicacion.get(Calendar.YEAR)+
						"</td><td><a href='./editarlibro?referencia="+
						tmp.referencia+"'>Editar</a>/<a href='./editarlibro?eliminar=true&referencia="+
						tmp.referencia+"'>Eliminar</a></td></tr>");
			}
		}
		pw.println("</table>");
		pw.println("<a href='./crear'>Crear libro</a>");
		}
		pw.println(HtmlUtilities.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
