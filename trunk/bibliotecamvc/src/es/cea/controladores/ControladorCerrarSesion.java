package es.cea.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.CerrarSesionUsuarioException;
import es.cea.excepcion.LoginException;
import es.cea.recursos.AtributosConstantes;

public class ControladorCerrarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		if(request.getSession().getAttribute(AtributosConstantes.usuarioRegistrado.toString())!=null){
				request.getSession().invalidate();
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/usuario/cerrarsesion.jsp");
				requestDispatcher.forward(request, response);
			}
		
		else{
			request.setAttribute("error", new CerrarSesionUsuarioException("No existe ninguna sesión abierta"));
		 	request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
		}
	}catch (BibliotecaDaoExcepcion e) {
			e.printStackTrace();
			
	}
	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
