package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaSolicitudesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Solicitud> solicitudes=(List<Solicitud>)request.getSession().getServletContext().getAttribute(AtributosConstantes.solicitudes.toString());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuAdmin);
		pw.println("<h3 style='color: #FF0000'>GESTIONAR SOLICITUDES</h3>");
		
		
		if(request.getParameter("aceptar")!=null){
			//pw.println("entramos en el primer if");
			for(Solicitud s:solicitudes){
				//pw.println("entramos en el for");
				//pw.println(s.usuario.mail.toString()+"==");
				//pw.println(request.getParameter("mail"));
				if(s.usuario.mail.equals(request.getParameter("mail"))){
					//pw.println("el if que deberia");
					s.aceptar();
				}
			}
		}
		if(request.getParameter("denegar")!=null){
			for(Solicitud s:solicitudes){
				if(s.usuario.mail.equals(request.getParameter("mail"))){ 
					s.denegar();
				}
			}
		}
		
			String acept="";
			pw.println("<table border='1'>"+
					"<tr><td>NOMBRE</td><td>MAIL</td><td>ACEPTADA</td><td>ACCION</td></tr>");
			for(Solicitud s:solicitudes){
				if(s!=null){
				acept=(s.aceptada)?"SI":"NO";
				pw.println("<tr><td>"+s.usuario.nombre+"</td><td>"+s.usuario.mail+"</td><td>"+
						acept+"</td><td><a href='./listasolicitudes?aceptar=true&mail="+s.usuario.mail+
						"'>Aceptar</a>/<a href='./listasolicitudes?denegar=true&mail="+s.usuario.mail+"'>Denegar</a></td></tr>");
				}
			}
			pw.println("</table>");
		
		
		pw.println(HtmlUtilities.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
