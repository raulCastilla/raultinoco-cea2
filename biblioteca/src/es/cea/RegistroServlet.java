package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegistroServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			List<Solicitud> solicitud=(List<Solicitud>)request.getSession().getServletContext().getAttribute(AtributosConstantes.solicitudes.toString());
			List<Usuario> usuario=(List<Usuario>)request.getSession().getServletContext().getAttribute(AtributosConstantes.usuarios.toString());
			response.setContentType("text/html");
	        PrintWriter writer = response.getWriter();
	        
	        HtmlUtilities html=new HtmlUtilities("Registro");
	        
			writer.println(html.head);
			writer.println(html.cuerpo);
			if(request.getParameter("enviar")!=null){
				Usuario nuevo=new Usuario(request.getParameter("nombre"),request.getParameter("mail"),request.getParameter("clave"));
				Solicitud sol=new Solicitud(nuevo,solicitud,usuario);
				usuario.add(nuevo);
				solicitud.add(sol);
				writer.println("SOLICITUD ENVIADA!!<br>");
			}
			else{
				writer.println("<form action='./registro?enviar=true' method='post'>" +
	        		"<table>"+
	        		"<tr><td>Nombre:</td><td><input type='text' name='nombre' /></td></tr>" +
	                "<tr><td>Mail:</td><td><input type='text' name='mail' /></td></tr>" +
	                "<tr><td>Clave:</td><td><input type='password' name='clave' /></td></tr>" +
	                "<tr><td><input type='submit' value='Solicitar'/></td><td></td></tr></table></form>");
			}
	        
	        
	        
	        writer.println("<a href='./biblioteca'>Ir a la lista de libros</a>");
			writer.println(html.fin);
			writer.close();
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	

}
