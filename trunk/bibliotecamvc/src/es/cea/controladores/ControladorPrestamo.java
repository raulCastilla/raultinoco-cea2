package es.cea.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.modelo.Libro;
import es.cea.dao.Dao;
import es.cea.dao.modelo.Prestamo;
import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.LoginException;
import es.cea.excepcion.PrestamoException;
import es.cea.recursos.AtributosConstantes;

public class ControladorPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Dao<Prestamo> daop = (Dao<Prestamo>)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoPrestamo.toString());
	Dao<Libro> daol = (Dao<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoLibro.toString());
	Integer numPrestamo = (Integer)request.getSession().getAttribute(AtributosConstantes.numeroPrestamos.toString());
	Dao<Usuario> daou = (Dao<Usuario>)request.getSession().getAttribute(AtributosConstantes.daoUsuario.toString());
	
	try{
		String refRequest=request.getParameter("referencia");//recojo la referencia del libro 
		Libro libroActual=daol.obtener(refRequest);
		
		Boolean usuarioPoder = request.getParameter("permitido");//compruebo si el usuario puede o no coger libros
		Usuario usuarioActual= daou.obtener(usuarioPoder);
		
		Integer presRequest=request.getParameter("numPrestamo");//miro num de prestamos de ese usuario
		Usuario usuarioPrestamos= daou.obtener(presRequest);
		
		
			if(usuarioActual.getPermitido().booleanValue()==true){//si es que si
				if(libroActual.getPrestado().booleanValue()==false){//compruebo que prestado =false
					if(usuarioPrestamos.getNumPrestamo().equals(3)){
					 	request.setAttribute("error", new PrestamoException("No puede realizar más prestamos"));
					 	request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
					}
					else{
						//realizo el prestamo
						String libEscogido= request.getParameter("referencia");
						Libro nombreLibro=daol.obtener(libEscogido);
						String usuPrestamo=request.getParameter("correo");
						Usuario nombreUsuario=daou.obtener(usuPrestamo);
						//Prestamo prestamoRealizado=daop.agregar(nombreLibro);
						//nombreLibro.getPrestado().booleanValue()=true;
						//nombreUsuario.getNumPrestamo()-->sumarle uno
						
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("/usuario/prestamos.jsp");
						requestDispatcher.forward(request, response);
					}
				}	
				else{
					//el libro esta a true
					request.setAttribute("error", new PrestamoException("El libro que ha seleccionado está prestado, por favor, elija otro"));
				 	request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
				}
			}
			else{
				//el usuario no tiene derecho coger libros
				request.setAttribute("error", new PrestamoException("Lo sentimos, no se le permite realizar préstamos"));
			 	request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
			}

		}
	catch(BibliotecaDaoExcepcion e){
		e.printStackTrace();
	}
			
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
