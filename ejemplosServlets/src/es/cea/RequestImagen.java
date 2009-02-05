package es.cea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestImagen
 */
public class RequestImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType( "text/html" ); 
		PrintWriter out = response.getWriter();
		
        out.println("<p>Inicio del dispatcher</p>"); 
        out.println( "<p><img border='2' src='" + request.getContextPath() +"/img/web.gif'></p>"); 
        out.println("<p>Fin de dispatcher. Esta imagen ha sido mostrada por el dispatcher</p>"); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
