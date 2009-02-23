package es.cea.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.excepcion.ParametroNuloExcepcion;

public class ControladorAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void forward(HttpServletRequest request, HttpServletResponse response, String uri) throws IOException,ServletException{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(uri);
		requestDispatcher.forward(request, response);
	}
	
	protected void compruebaNoNulo(HttpServletRequest request,String...parametros) throws ParametroNuloExcepcion{
		for(String par:parametros)
			if(request.getParameter(par)==null) throw new ParametroNuloExcepcion("Existen par‡metros nulos");
	}

}
