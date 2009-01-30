package es.cea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegistroServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			response.setContentType("text/html");
	        PrintWriter writer = response.getWriter();
	        
	        HtmlUtilities html=new HtmlUtilities("Registro");
	        
			writer.println(html.head);
			writer.println(html.cuerpo);
	
	        writer.println("<form action='./solicitud' method='post'>" +
	        		"<table>"+
	        		"<tr><td>Nombre:</td><td><input type='text' name='nombre' /></td></tr>" +
	                "<tr><td>Mail:</td><td><input type='text' name='mail' /></td></tr>" +
	                "<tr><td>Clave:</td><td><input type='password' name='clave' /></td></tr>" +
	                "<tr><td><input type='submit' value='Solicitar'/></td><td></td></tr></table></form>");

	        
	        
	        
	        
			writer.println(html.fin);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	

}
