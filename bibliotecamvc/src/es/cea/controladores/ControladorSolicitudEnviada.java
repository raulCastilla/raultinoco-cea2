package es.cea.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.cea.dao.modelo.Usuario;
import es.cea.dao.Dao;
import es.cea.dao.implement.DaoSolicitud;
import es.cea.dao.implement.DaoUsuario;
import es.cea.dao.modelo.Solicitud;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.recursos.AtributosConstantes;


public class ControladorSolicitudEnviada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	List<Usuario> listaUsuario;
	//	List<Solicitud> listaSolicitud;
		Dao<Usuario> daoU = (Dao<Usuario>)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoUsuario.toString());
		Dao<Solicitud> daoS = (Dao<Solicitud>)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoSolicitud.toString());

	
	//Usuario nuevoUsuario=new Usuario(request.getParameter("nombre"),request.getParameter("mail"), request.getParameter("clave"));
	//Solicitud nuevaSolicitud=new Solicitud(nuevoUsuario,listaUsuario,listaSolicitud);
	//daoU.agregar(nuevoUsuario);
	//daoS.agregar(nuevaSolicitud);
	//request.getRequestDispatcher("/index").forward(request, response);
		request.getRequestDispatcher("/index").forward(request, response);

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}

}
