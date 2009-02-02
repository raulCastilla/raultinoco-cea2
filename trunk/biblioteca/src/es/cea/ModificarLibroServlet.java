package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarLibroServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Libro> lista = (List<Libro>) req.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		HtmlUtilities html = new HtmlUtilities("Modificar Libro");
		writer.println(html.head);
		writer.println(html.cuerpo);
		
		String ref = req.getParameter("ref");
		Libro libroMod = null;
		
		for(Libro lib: lista){
			if(lib.referencia.equals(ref))
				libroMod = lib;
		}
		
		if(req.getParameter("modificar")!=null){
			libroMod.titulo = req.getParameter("titulo");
			libroMod.genero.nombre = req.getParameter("genero");
			libroMod.autor.nombre = req.getParameter("autor");
			writer.println("<h1>LIBRO MODIFICADO!!</h1>");
			writer.println("<hr><a href='./menuadmin'>Volver a menu de Administrador</a>");
		}
		
		else{
		writer.println("<h1>LIBRO A MODIFICAR: "+libroMod.referencia+"</h1><hr>");
		writer.println("<pre><form action='./modificar' method='post'>");
		writer.println("TITULO: <input type='text' name='titulo' value='"+libroMod.titulo+"'><br><br>");
		writer.println("GENERO: <input type='text' name='genero' value='"+libroMod.genero+"'><br><br>");
		writer.println(" AUTOR: <input type='text' name='autor' value='"+libroMod.autor+"'><br><br>");
		writer.println("<input type='hidden' name='ref' value='"+libroMod.referencia+"'>");
		writer.println("        <input type='submit' value='Modificar' name='modificar'></form></pre><hr>");
		writer.println("<h3><a href='./menuadmin'>Volver a menu de Administrador</a></h3>");
		}
		writer.println(html.fin);
		writer.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
