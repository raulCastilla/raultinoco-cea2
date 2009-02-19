package es.cea.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Genero;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class GeneroService extends ForwardService{

	@Override
	public void add(HttpServletRequest request, HttpServletResponse response,
			Object ob, String uri, Dao dao) throws BibliotecaDaoExcepcion,
			IOException, ServletException {
		// TODO Auto-generated method stub
		String nombre = (String)ob;
		Genero gen=new Genero(nombre);
		
		try{
			dao.agregar(gen);
			request.setAttribute("lista", dao.obtenerLista());
			forward(request, response, uri);
		}
		catch(BibliotecaDaoExcepcion e){
			System.out.println("El g始ero ya existe");
			request.setAttribute("lista", dao.obtenerLista());
			request.setAttribute("error", getErrorExiste());
			forward(request, response, uri);
		}
	}

	@Override
	public void delete(HttpServletRequest request,
			HttpServletResponse response, Dao dao, String uri, Object ob)
			throws BibliotecaDaoExcepcion, IOException, ServletException {
		// TODO Auto-generated method stub
		String nombre = (String)ob;
		try{
			dao.eliminar(dao.obtener(nombre));
			forward(request, response, uri);
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("El g始ero no existe");
			request.setAttribute("error", getErrorNoExiste());
			forward(request, response, uri);
		}
	}

	@Override
	public String getErrorExiste() {
		// TODO Auto-generated method stub
		return "El g始ero ya existe";
	}

	@Override
	public String getErrorList() {
		// TODO Auto-generated method stub
		return "No se ha podido acceder a la lista de g始eros";
	}

	@Override
	public String getErrorNoExiste() {
		// TODO Auto-generated method stub
		return "El g始ero no existe";
	}

	@Override
	public void showForm(HttpServletRequest request,
			HttpServletResponse response, String uri, Object ob)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String atributo = (String)ob;
		request.setAttribute("atributo", atributo);
		forward(request, response, uri);
	}

	@Override
	public void showList(HttpServletRequest request,
			HttpServletResponse response, Dao dao, String uri)
			throws BibliotecaDaoExcepcion, IOException, ServletException {
		// TODO Auto-generated method stub
		try{
			request.setAttribute("lista", dao.obtenerLista());
			forward(request, response, uri);
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("no se ha podido obtener la lista de g始eros");
			request.setAttribute("error", getErrorList());
			forward(request, response, uri);
		};
	}

	@Override
	public void update(HttpServletRequest request,
			HttpServletResponse response, Dao dao, String uri, Object obOld,
			Object obNew) throws BibliotecaDaoExcepcion, IOException,
			ServletException {
		// TODO Auto-generated method stub
		String nombre = (String)obOld;
		String nuevoNombre = (String)obNew;
		try{
			Genero gen=(Genero)dao.obtener(nombre);
			gen.setNombre(nuevoNombre);
			forward(request, response, uri);
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("El g始ero no existe");
			request.setAttribute("error", getErrorNoExiste());
			forward(request, response, uri);
		}
	}
	
}
