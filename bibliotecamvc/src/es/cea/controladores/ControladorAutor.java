package es.cea.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.dao.implement.DaoAutor;
import es.cea.dao.modelo.Autor;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.recursos.AtributosConstantes;

public class ControladorAutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	public ControladorAutor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected String getErrorListaNoDisponible(){
		return "No se ha podido obtener la lista de autores";
	}
	
	protected String getErrorNoExiste(){
		return "El autor no existe";
	}
	
	protected String getErrorYaExiste(){
		return "El autor ya existe";
	}
	
	protected Dao getDao(HttpServletRequest request) {
		return (DaoAutor)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoAutor.toString());
	}

	
	protected String getUri() {
		return "/administrador/autores.jsp";
	}
	*/
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao = (DaoAutor)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoAutor.toString());
		AutorService serv = new AutorService();
		String uri = "/administrador/autores.jsp";
			try{
			if(request.getParameter("nombre")!=null){
				
				serv.add(request, response,request.getParameter("nombre"),uri,dao);
			}
			else if(request.getParameter("crear")!=null){
				serv.showForm(request, response, "/administrador/creaAutor.jsp",null);
			}
			else if(request.getParameter("editar")!=null){
				request.setAttribute("autor", dao.obtener(request.getParameter("nameup")));
				serv.showForm(request, response, "/administrador/editAutor.jsp",request.getParameter("nameup"));
			}
			else if(request.getParameter("eliminar")!=null){
				request.setAttribute("lista", dao.obtenerLista());
				
				serv.delete(request, response, dao, uri,request.getParameter("namedel"));
			}
			else if(request.getParameter("modificar")!=null){
				request.setAttribute("lista", dao.obtenerLista());

				serv.update(request, response, dao, uri, request.getParameter("nameOld"),request.getParameter("autor"));
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
	
	/*
	private void modificar(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		try{
			Autor aut=(Autor)getDao(request).obtener(request.getParameter("nombre"));
			aut.setNombre(request.getParameter("nombre"));
			forward(request, response, getUri());
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("El autor no existe");
			request.setAttribute("error", getErrorNoExiste());
			forward(request, response, getUri());
		}
	}


	
	private void eliminar(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		try{
			getDao(request).eliminar(getDao(request).obtener(request.getParameter("nombre")));
			forward(request, response, getUri());
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("El autor no existe");
			request.setAttribute("error", getErrorNoExiste());
			forward(request, response, getUri());
		}
	}



	
	private void mostrarFormulario(HttpServletRequest request,
			HttpServletResponse response) throws IOException,
			ServletException {
		request.setAttribute("crear", true);
		forward(request, response, getUri());
	}
	
	private void mostrarLista(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		try{
			request.setAttribute("lista", getDao(request).obtenerLista());
			forward(request, response, getUri());
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("no se ha podido obtener la lista de autores");
			request.setAttribute("error", getErrorListaNoDisponible());
			forward(request, response, getUri());
		}
	}


	private void agregar(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		try{
			getDao(request).agregar(new Autor(request.getParameter("nombre")));
			request.setAttribute("lista", getDao(request).obtenerLista());
			forward(request, response, getUri());
		}
		catch(BibliotecaDaoExcepcion e){
			System.out.println("El autor ya existe");
			request.setAttribute("error", getErrorYaExiste());
			forward(request, response, getUri());
		}
	}

	
	private void forward(HttpServletRequest request, HttpServletResponse response, String uri) throws IOException,ServletException{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(uri);
		requestDispatcher.forward(request, response);
	}
	*/

}
