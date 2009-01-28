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
	        		"Nombre:<input type='text' name='nombre' /><br>" +
	                "Mail:<input type='text' name='mail' /><br>" +
	                "Clave: <input type='password' name='clave' /><br>" +
	                "<input type='submit' value='Log In'/></form>");

	        
	        
	        
	        
			writer.println(html.fin);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	

}
