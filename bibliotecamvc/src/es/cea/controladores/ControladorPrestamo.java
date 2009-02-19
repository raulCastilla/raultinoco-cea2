package es.cea.controladores;

import java.io.IOException;
import java.util.Calendar;
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
		
	Dao<Prestamo> daoP = (Dao<Prestamo>)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoPrestamo.toString());
	Dao<Libro> daoL = (Dao<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoLibro.toString());
	Dao<Usuario> daoU = (Dao<Usuario>)request.getSession().getAttribute(AtributosConstantes.daoUsuario.toString());
	
	try{
		String refRequest=request.getParameter("referencia");//recojo la referencia del libro 
		Libro libroActual=daoL.obtener(refRequest);
		//String titRequest=request.getParameter("titulo");
		//Libro titActual=daoL.obtener(titRequest);
		
		String usuarioPoder = request.getParameter("permitido");//compruebo si el usuario puede o no coger libros
		Usuario usuarioActual= daoU.obtener(usuarioPoder);
		Integer numPrestamo = usuarioActual.getNumPrestamo();
		
		if(usuarioActual.getPermitido().booleanValue()==true){//si es que si
			if(libroActual.getPrestado().booleanValue()==false){//compruebo que prestado =false
				if(numPrestamo.intValue()==3){
					 request.setAttribute("error", new PrestamoException("No puede realizar más prestamos"));
					 request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
				}
				else{
					//crear nuevo prestamo
					Calendar iniCalendar=Calendar.getInstance();
					Calendar finCalendar=Calendar.getInstance();
					finCalendar.roll(Calendar.DAY_OF_YEAR, 5);
					Prestamo nuevoPrestamo= new Prestamo(usuarioActual,libroActual,iniCalendar,finCalendar);
					daoP.agregar(nuevoPrestamo);
					numPrestamo++;//sumarle 1 al número de prestamos de ese usuario
					libroActual.setPrestado(true);//atributo prestado a true
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("usuario/prestamos.jsp");
					requestDispatcher.forward(request, response);
				}
			}	
			else{
				//el libro está ya prestado 
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
