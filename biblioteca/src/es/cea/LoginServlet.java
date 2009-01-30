package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.AtributosConstantes;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = (List<Usuario>)request.getSession().getServletContext().getAttribute(AtributosConstantes.usuarios.toString());
		
		response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        
        HtmlUtilities html=new HtmlUtilities("Login");
        
		writer.println(html.head);
		writer.println(html.cuerpo);
		//Comprobamos que se ha enviado un mail y clave
		if(request.getParameter("mail")!=null&&request.getParameter("clave")!=null){
			for(Usuario tmp:usuarios){
				//Comprobamos que existe un usuario con esas credenciales
				if(tmp.mail.equals(request.getParameter("mail"))&&tmp.clave.equals(request.getParameter("clave"))){
					//Guardamos en una variable de sesion el usuario que se loguea
					request.getSession().setAttribute(AtributosConstantes.usuarioRegistrado.toString(), tmp);
					//Si existe una peticion de prestamo me reenvia al servlet de prestamos en caso contrario unicamente se loguea
					String peticionActual=(String)request.getSession().getAttribute(AtributosConstantes.peticionActual.toString());
					if(peticionActual!=null) request.getRequestDispatcher(peticionActual).forward(request, response);
				}
				else{
					writer.println("<h4>NO EXITE NINGUN USUARIO CON ESE MAIL Y CLAVE. INTENTELO DE NUEVO</h4><br>");
					writer.println("<a href='./login'>Intentelo de nuevo</a>");
				}
			}
		}
		if(request.getSession().getAttribute(AtributosConstantes.usuarioRegistrado.toString())==null){
			writer.println("<form action='./login' method='post'>" +
        		"<table>"+
                "<tr><td>Mail:</td><td><input type='text' name='mail' /></td></tr>" +
                "<tr><td>Clave:</td><td><input type='password' name='clave' /></td></tr>" +
                "<tr><td><input type='submit' value='Log In'/></td><td></td></tr></table></form>");
		}
		writer.println(html.fin);
		writer.close();

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
