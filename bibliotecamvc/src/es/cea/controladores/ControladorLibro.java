package es.cea.controladores;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.dao.implement.DaoLibro;
import es.cea.dao.modelo.Libro;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.FechaNoValidaException;
import es.cea.excepcion.ParametroNuloExcepcion;
import es.cea.recursos.AtributosConstantes;
import es.cea.servicios.ServicioCalendario;

public class ControladorLibro extends ControladorAdministrador{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Dao dao = (DaoLibro)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoLibro.toString());
//		LibroService serv = new LibroService();
		BookService book = new BookService();
		String uri = "/administrador/libros.jsp?accion=mostrar";
		ServicioCalendario servCal = new ServicioCalendario();
		
		try{
			compruebaNoNulo(request, "accion");
			
			if(request.getParameter("accion").equals("mostrar")){
				request.setAttribute("lista", dao.obtenerLista());
				forward(request, response, uri);
			}
			if(request.getParameter("accion").equals("create")){
				compruebaNoNulo(request, "referencia","titulo","fecha","genero","autor");
				try {
					book.add(request.getParameterMap(), dao);
					request.setAttribute("lista", dao.obtenerLista());
					forward(request, response, uri);
				} catch (FechaNoValidaException e) {
					request.setAttribute("error", e.getMessage());
					forward(request, response, uri);
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "El libro ya existe en la biblioteca");
					forward(request, response, uri);
				}
				
			}
			
			if(request.getParameter("accion").equals("crear"))
				forward(request, response, "/administrador/creaLibro.jsp");
			
			if(request.getParameter("accion").equals("editar")){
				compruebaNoNulo(request, "referencia");
				Libro l = (Libro)dao.obtener(request.getParameter("referencia"));
				request.setAttribute("fecha", servCal.calendarioToString(l.getFechaPublicacion()));
				request.setAttribute("libro",l);
				forward(request, response, "/administrador/editLibro.jsp");
			}
			
			if(request.getParameter("accion").equals("eliminar")){
				compruebaNoNulo(request, "referencia");
				request.setAttribute("lista", dao.obtenerLista());
				try {
					book.delete(dao, request.getParameter("referencia"));
					request.setAttribute("lista", dao.obtenerLista());
					forward(request, response, uri);
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "El libro no existe");
					forward(request, response, uri);
				}
			}
			
			if(request.getParameter("accion").equals("modificar")){
				compruebaNoNulo(request, "refOld","referencia","titulo","autor","genero","fecha");
				request.setAttribute("lista", dao.obtenerLista());
				try {
					book.update(dao, request.getParameterMap());
					forward(request, response, uri);
				} catch (FechaNoValidaException e) {
					request.setAttribute("error", e.getMessage());
					Libro l = (Libro)dao.obtener(request.getParameter("referencia"));
					request.setAttribute("fecha", servCal.calendarioToString(l.getFechaPublicacion()));
					request.setAttribute("libro",l);
					forward(request, response, "./administrador/editLibro.jsp");
					
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "No se ha podido modificar el libro");
					forward(request, response, uri);
				}
			}
			
			
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
		} catch (ParametroNuloExcepcion e) {
			
			request.setAttribute("error", "Faltan par‡metros");
			forward(request, response, "./libro?accion=crear");
		}
		
	}
	

}
