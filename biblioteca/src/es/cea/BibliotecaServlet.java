package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BibliotecaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> libros = (List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HtmlUtilities html = new HtmlUtilities("Biblioteca");
		String prest="";
		pw.println(html.head);
		pw.println(html.cuerpo);
		pw.println("<table>");
		pw.println("<tr><td>TITULO</td><td>DETALLES</td><td>ALQUILADO</td></tr>");
		for(Libro tmp : libros){
			prest = (tmp.prestado)?"SI":"NO";
			pw.println("<tr><td>"+tmp.titulo+"</td><td><a href='./detalle?ref="+tmp.referencia+"'>Ver</a></td><td>"+prest+"</td></tr>");
		}
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
