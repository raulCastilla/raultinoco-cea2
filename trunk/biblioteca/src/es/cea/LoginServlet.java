package es.cea;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = (List<Usuario>)request.getSession().getServletContext().getAttribute(AtributosConstantes.usuarios.toString());
		for(Usuario tmp:usuarios){
			if(tmp.mail.equals(request.getParameter("mail"))&&tmp.clave.equals(request.getParameter("clave"))){
				request.getSession().setAttribute(AtributosConstantes.usuarioRegistrado.toString(), tmp);
			}
			else{
				System.out.println("NO EXITE NINGUN USUARIO CON ESE MAIL Y CLAVE. INTENTELO DE NUEVO");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
