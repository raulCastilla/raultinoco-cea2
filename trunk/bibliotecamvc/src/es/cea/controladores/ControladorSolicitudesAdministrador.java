package es.cea.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.dao.implement.DaoSolicitud;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.recursos.AtributosConstantes;

public class ControladorSolicitudesAdministrador extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = (DaoSolicitud)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoSolicitud.toString());
		SolicitudesService Solserv = new SolicitudesService();
		String uri = "/administrador/solicitudes.jsp";
		
		if(request.getParameter("mail")!=null){
		try{							
			if(request.getParameter("aceptar")!=null){				
					Solserv.add(request, response,request.getParameter("mail"),uri,dao);
				}
			
			else if(request.getParameter("eliminar")!=null){
//					request.setAttribute("lista", dao.obtenerLista());					
					Solserv.delete(request, response, dao, uri,request.getParameter("mail"));
				}
		}
		catch (BibliotecaDaoExcepcion e) {
			
		}
		}else{
		try{
			request.setAttribute("lista", dao.obtenerLista());			
			
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("no se ha podido obtener la lista de solicitudes");
			request.setAttribute("error", "No se ha podido obtener la lista de solicitudes");
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/administrador/solicitudes.jsp");
		requestDispatcher.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
