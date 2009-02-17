package es.cea.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.implement.DaoLibro;
import es.cea.dao.modelo.Libro;
//import es.cea.excepcion.DetalleException;
import es.cea.recursos.AtributosConstantes;

public class ControladorDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ControladorDetalle() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoLibro dao = (DaoLibro)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoLibro.toString());

		//try{
			List<Libro> libros=dao.getLista();
			for(Libro l:libros){
				l.getReferencia();
			}
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/usuario/detalle.jsp?referencia=l.get.Referencia()");
			requestDispatcher.forward(request, response);
		//}
		//catch(DetalleException d){
		//	System.out.println("No se ha podido obtener el detalle del libro solicitado, inténtelo de nuevo");
		//}
		
		
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
	}

}
