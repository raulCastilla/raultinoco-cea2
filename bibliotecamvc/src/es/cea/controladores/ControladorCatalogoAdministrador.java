package es.cea.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.recursos.AtributosConstantes;

public class ControladorCatalogoAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = (Dao)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoLibro.toString());
		try{
			request.setAttribute("lista", dao.obtenerLista());
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("no se ha podido obtener el catalogo");
			request.setAttribute("error", "No se ha podido obtener el catalogo");
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/administrador/catalogo.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
