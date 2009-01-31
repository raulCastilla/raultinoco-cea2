package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BibliotecaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> libros = (List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		if(request.getParameter("genero")!=null){
			Collections.sort(libros,new ComparatorGenero());
		}
		else if(request.getParameter("autor")!=null){
			Collections.sort(libros, new ComparatorAutor());
		}
		else{
			Collections.sort(libros);
		}
		response.setContentType("text/html");
		//response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		HtmlUtilities html = new HtmlUtilities("Biblioteca");
		String prest="";
		pw.println(html.head);
		pw.println(html.cuerpo);
		pw.println("<a href='./biblioteca?genero=true'>Ordenar por genero</a>/<a href='./biblioteca?autor=true'>Ordenar por autor</a><br>");
		pw.println("<table border='1'>");
		pw.println("<tr><td>T&Iacute;TULO</td><td>G&Eacute;NERO</td><td>AUTOR</td><td>DETALLES</td><td>ALQUILADO</td></tr>");
		for(Libro tmp : libros){
			prest = (tmp.prestado)?"SI":"NO";
			pw.println("<tr><td>"+tmp.titulo+"</td><td>"+tmp.genero+"</td><td>"+tmp.autor+"</td><td><a href='./detalle?ref="+tmp.referencia+"'>Ver</a></td><td>"+prest+"</td></tr>");
		}
		pw.println("</table>");
		pw.println("<a href='./consultaprestamo'>Consultar mis prestamos</a><br>");
		pw.println("<a href='./login'>Log in</a><br>");
		pw.println("<a href='./registro'>Enviar sollicitud de registro</a><br>");
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
