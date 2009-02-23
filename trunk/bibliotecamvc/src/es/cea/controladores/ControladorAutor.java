package es.cea.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.dao.implement.DaoAutor;
import es.cea.dao.modelo.Autor;

import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.ParametroNuloExcepcion;
import es.cea.recursos.AtributosConstantes;

public class ControladorAutor extends ControladorAdministrador{

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dao<Autor> dao = (DaoAutor)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoAutor.toString());
	
		AutorService autorService = new AutorService();
		String uri = "/administrador/autores.jsp?accion=mostrar";
		
		try {
			compruebaNoNulo(request, "accion");
			
			if(request.getParameter("accion").equals("mostrar")){
				request.setAttribute("lista", dao.obtenerLista());
				forward(request, response, uri);
			}
			
			if(request.getParameter("accion").equals("create")){
				compruebaNoNulo(request, "nombre");
				try {
					autorService.add(request.getParameter("nombre"), dao);
					request.setAttribute("lista", dao.obtenerLista());
					forward(request, response, uri);
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "El autor ya existe");
					forward(request, response, "/administrador/creaAutor.jsp");
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
			if(request.getParameter("accion").equals("crear")){
				forward(request, response, "/administrador/creaAutor.jsp");
			}
			
			if(request.getParameter("accion").equals("modificar")){
				compruebaNoNulo(request, "nameOld","nameNew");
				
				try {
					autorService.update(dao, request.getParameterMap());
					request.setAttribute("lista", dao.obtenerLista());
					forward(request, response, uri);
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "No se ha podido modificar el autor");
					forward(request, response, uri);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			if(request.getParameter("accion").equals("editar")){
				compruebaNoNulo(request, "nombre");
				try{
					Autor aut = (Autor)dao.obtener(request.getParameter("nombre"));
					request.setAttribute("autor", aut);
					forward(request, response, "/administrador/editAutor.jsp");
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "No existe el autor");
					forward(request, response, uri);
				}
			}
			
			if(request.getParameter("accion").equals("eliminar")){
				compruebaNoNulo(request, "nombre");
				try {
					autorService.delete(dao, request.getParameter("nombre"));
					request.setAttribute("lista", dao.obtenerLista());
					forward(request, response, uri);
				} catch (BibliotecaDaoExcepcion e) {
					request.setAttribute("error", "No se ha podido eliminar el autor");
					forward(request, response, uri);
				}
			}
			
		} catch (ParametroNuloExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BibliotecaDaoExcepcion e) {
			request.setAttribute("error", "No se puede obtener la lista de autores");
			forward(request, response, uri);
		}
	}
	
}
