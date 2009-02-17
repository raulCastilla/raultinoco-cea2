package es.cea.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.Dao;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.recursos.AtributosConstantes;

public class ControladorGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = (Dao)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoGenero.toString());
		try{
			List lista = dao.obtenerLista();
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("/administrador/generos.jsp").forward(request, response);
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("no se ha podido obtener la lista de generos");
			request.setAttribute("error", "No se ha podido obtener la lista de generos");
			request.getRequestDispatcher("/administrador/error.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
