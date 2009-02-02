package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EliminarLibroServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Libro> misLibros = (List<Libro>) req.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		HtmlUtilities html = new HtmlUtilities("Eliminar Libro");
		pw.println(html.head);
		pw.println(html.cuerpo);
		
		String ref = req.getParameter("ref");
		Libro libroSentenciado = null;
		
		for(Libro lib : misLibros){
			if(lib.referencia.equals(ref))
				libroSentenciado = lib;
		}
		
		if(req.getParameter("confirmar")!=null){
			misLibros.remove(libroSentenciado);
			pw.println("<h1>EL LIBRO "+libroSentenciado.titulo+" HA SIDO ELIMINADO<h1>");
			pw.println("<hr><a href='./menuadmin'>Volver a menu de Administrador</a>");
		}
		
		
		else{
			pw.println("<h1>LIBRO A ELIMINAR: "+libroSentenciado.referencia+"</h1><hr>");
            pw.println("<h2>TITULO: "+libroSentenciado.titulo+"</h2><br>");
            pw.println("<h2>GENERO: "+libroSentenciado.genero+"</h2><br>");
            pw.println("<h2>AUTOR: "+libroSentenciado.autor+"</h2>");
            pw.println("<hr><a href='./eliminar?referencia="+libroSentenciado.referencia+"&confirmar=true'>Confirmar</a><br>");
            pw.println("<a href='./menuadmin'>Volver a menu de Administrador</a>");

		}
		pw.println(html.fin);
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req,resp);
	}

}
