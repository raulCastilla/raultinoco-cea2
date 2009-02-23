package es.cea.controladores;




import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.cea.dao.Dao;
import es.cea.dao.implement.DaoSolicitud;
import es.cea.dao.implement.DaoUsuario;
import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Libro;
import es.cea.dao.modelo.Prestamo;
import es.cea.dao.modelo.Usuario;
import es.cea.dao.modelo.Solicitud;
import es.cea.dao.modelo.UsuarioNoRegistrado;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.recursos.AtributosConstantes;



public class ControladorSolicitudEnviada extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao daoU = (DaoUsuario)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoUsuario.toString());
		Dao daoS = (DaoSolicitud)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoSolicitud.toString());
		
		Usuario nuevoUsuario=new UsuarioNoRegistrado(request.getParameter("nombre"),request.getParameter("mail"), request.getParameter("clave"));
		Solicitud nuevaSolicitud = new Solicitud(nuevoUsuario);
		
			try {
				
				daoU.agregar(nuevoUsuario);
				daoS.agregar(nuevaSolicitud);
				request.getRequestDispatcher("./index").forward(request, response);
			} catch (BibliotecaDaoExcepcion e) {
				request.setAttribute("error", "El usuario que intenta registrar ya existe");
				request.getRequestDispatcher("/usuario/error.jsp").forward(request, response);
			}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	
	}
}
