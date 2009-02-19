package es.cea.controladores;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.dao.implement.DaoGenero;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.recursos.AtributosConstantes;


public class ControladorGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = (DaoGenero)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoGenero.toString());
		GeneroService serv = new GeneroService();
		String uri = "/administrador/generos.jsp";
			try{
			if(request.getParameter("nombre")!=null){
				
				serv.add(request, response,request.getParameter("nombre"),uri,dao);
			}
			else if(request.getParameter("crear")!=null){
				serv.showForm(request, response, "/administrador/creaGenero.jsp",null);
			}
			else if(request.getParameter("editar")!=null){
				request.setAttribute("genero", dao.obtener(request.getParameter("nameup")));
				serv.showForm(request, response, "/administrador/editGenero.jsp",request.getParameter("nameup"));
			}
			else if(request.getParameter("eliminar")!=null){
				request.setAttribute("lista", dao.obtenerLista());
				
				serv.delete(request, response, dao, uri,request.getParameter("namedel"));
			}
			else if(request.getParameter("modificar")!=null){
				request.setAttribute("lista", dao.obtenerLista());

				serv.update(request, response, dao, uri, request.getParameter("nameOld"),request.getParameter("genero"));
			}
			else{
				serv.showList(request, response, dao, uri);
			}
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	



}
