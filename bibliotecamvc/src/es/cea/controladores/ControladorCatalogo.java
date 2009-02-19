package es.cea.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.dao.implement.DaoLibro;
import es.cea.dao.modelo.Genero;
import es.cea.dao.modelo.Libro;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.recursos.AtributosConstantes;


public class ControladorCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = (Dao)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoLibro.toString());
		try{
			List libros = dao.obtenerLista();
			request.setAttribute("lista", libros);
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("No se ha podido obtener la lista de libros");
			request.setAttribute("error", "No se ha podido obtener la lista de libros");
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/usuario/catalogo.jsp");
		requestDispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
