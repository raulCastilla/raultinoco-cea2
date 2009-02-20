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
import es.cea.dao.modelo.Libro;
import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;
//import es.cea.excepcion.DetalleException;
import es.cea.recursos.AtributosConstantes;

public class ControladorDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String referencia = request.getParameter("referencia");
		
		Dao<Libro> dao = (Dao<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoLibro.toString());

		try {
			Libro l=dao.obtener(referencia);
			request.setAttribute("libroSeleccionado", l);
		
						
			
			request.getRequestDispatcher("usuario/detalle.jsp").forward(request, response);
			
			
		} catch (BibliotecaDaoExcepcion e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
		}
		
		
		
		
		
			
			
			
			
		
		
			
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
	}

}
