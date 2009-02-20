package es.cea.controladores;




import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Libro;
import es.cea.dao.modelo.Prestamo;
import es.cea.dao.modelo.Usuario;
import es.cea.dao.modelo.Solicitud;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.recursos.AtributosConstantes;



public class ControladorSolicitudEnviada extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Usuario> daoU = (Dao<Usuario>)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoUsuario.toString());
		Dao<Solicitud> daoS = (Dao<Solicitud>)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoSolicitud.toString());
		List solicitud = daoS.obtenerLista();
		List usuario= daoU.obtenerLista();
		Usuario nuevoUsuario=new Usuario(request.getParameter("nombre"),request.getParameter("mail"), request.getParameter("clave"));
		Solicitud nuevaSolicitud=new Solicitud(nuevoUsuario, usuario, solicitud);
		
		daoU.agregar(nuevoUsuario);
		daoS.agregar(nuevaSolicitud);
		request.getRequestDispatcher("./index").forward(request, response);
	

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}

}
