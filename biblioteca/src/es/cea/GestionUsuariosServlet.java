package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GestionUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios=(List<Usuario>)request.getSession().getServletContext().getAttribute(AtributosConstantes.usuarios.toString());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuAdmin);
		pw.println("<h3 style='color: #FF0000'>GESTIONAR USUARIOS</h3>");
		
		if(request.getParameter("permitir")!=null){
			for(Usuario us:usuarios){
				if(us.mail.equals(request.getParameter("usuario"))) us.permitido=true;
				response.sendRedirect("/biblioteca/admin/gestionusuarios");
			}
		}
		else if(request.getParameter("denegar")!=null){
			for(Usuario us:usuarios){
				if(us.mail.equals(request.getParameter("usuario"))) us.permitido=false;
				response.sendRedirect("/biblioteca/admin/gestionusuarios");
			}
		}
		else if(request.getParameter("eliminar")!=null){
			for(int i=0;i<usuarios.size();i++){
				if(usuarios.get(i).mail.equals(request.getParameter("usuario"))) usuarios.remove(i);
				response.sendRedirect("/biblioteca/admin/gestionusuarios");
			}
		}
		else{
		pw.println("<table border='1'>");
		pw.println("<tr><td>NOMBRE</td><td>MAIL</td><td>PRESTAMOS</td><td>PERMITIR</td><td>REGISTRADO</td><td>ACCIONES</td></tr>");
		String per="";
		String reg="";
		for(Usuario user:usuarios){
			
			if(user!=null){
				reg=(user.registrado)?"SI":"NO";
				per=(user.permitido)?"SI":"NO";
				pw.println("<tr><td>"+user.nombre+"</td><td>"+user.mail+"</td><td>"+per+
					"</td><td><a href='./gestionusuarios?permitir=true&usuario="+
					user.mail+"'>Permitir</a>/<a href='./gestionusuarios?denegar=true&usuario="+
					user.mail+"'>Denegar</a></td><td>"+reg+"</td><td><a href='./gestionusuarios?eliminar=true&usuario="+user.mail+"'>Eliminar</a></td></tr>");
			}	
		}
		pw.println("</table");
		}
		pw.println(HtmlUtilities.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
