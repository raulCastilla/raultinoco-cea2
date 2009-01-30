package es.cea;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrearSolicitudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Solicitud> solicitud=(List<Solicitud>)request.getSession().getServletContext().getAttribute(AtributosConstantes.solicitudes.toString());
		List<Usuario> usuario=(List<Usuario>)request.getSession().getServletContext().getAttribute(AtributosConstantes.usuarios.toString());
		Usuario nuevo=new Usuario(request.getParameter("nombre"),request.getParameter("mail"),request.getParameter("clave"));
		Solicitud sol=new Solicitud(nuevo,solicitud,usuario);
		usuario.add(nuevo);
		solicitud.add(sol);
		System.out.println("Solicitud enviada");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
