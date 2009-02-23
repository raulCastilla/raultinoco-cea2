package es.cea.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.dao.implement.DaoGenero;
import es.cea.dao.modelo.Genero;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.ParametroNuloExcepcion;
import es.cea.recursos.AtributosConstantes;

public class ControladorGenero extends ControladorAdministrador{

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GenreService genre = new GenreService();
		String uri = "/administrador/generos.jsp?accion=mostrar";
		Dao dao = (DaoGenero)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoGenero.toString());
		try {
			compruebaNoNulo(request, "accion");
			if(request.getParameter("accion").equals("mostrar")){
				request.setAttribute("lista", dao.obtenerLista());
				forward(request, response, uri);
			}
			
			if(request.getParameter("accion").equals("create")){
				compruebaNoNulo(request, "nombre");
				try {
					genre.add(request.getParameter("nombre"), dao);
					request.setAttribute("lista", dao.obtenerLista());
					forward(request, response, uri);
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "El g始ero ya existe");
					forward(request, response, "/administrador/creaGenero.jsp");
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
			if(request.getParameter("accion").equals("crear")){
				forward(request, response, "/administrador/creaGenero.jsp");
			}
			
			if(request.getParameter("accion").equals("modificar")){
				compruebaNoNulo(request, "nameOld","nameNew");
				
				try {
					genre.update(dao, request.getParameterMap());
					request.setAttribute("lista", dao.obtenerLista());
					forward(request, response, uri);
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "No se ha podido modificar el g始ero");
					forward(request, response, uri);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			if(request.getParameter("accion").equals("editar")){
				compruebaNoNulo(request, "nombre");
				try{
					Genero gen = (Genero)dao.obtener(request.getParameter("nombre"));
					request.setAttribute("genero", gen);
					forward(request, response, "/administrador/editGenero.jsp");
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "No existe el g始ero");
					forward(request, response, uri);
				}
			}
			
			if(request.getParameter("accion").equals("eliminar")){
				compruebaNoNulo(request, "nombre");
				try {
					genre.delete(dao, request.getParameter("nombre"));
					request.setAttribute("lista", dao.obtenerLista());
					forward(request, response, uri);
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "No se ha podido eliminar el g始ero");
					forward(request, response, uri);
				}
			}
			
		} catch (ParametroNuloExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (BibliotecaDaoExcepcion e) {
			request.setAttribute("error", "No se puede mostrar la lista");
			forward(request, response, uri);
		}
		
	}

}
