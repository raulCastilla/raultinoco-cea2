package es.cea.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class ForwardService extends ForwardServiceAbstract{

	@Override
	public void add(HttpServletRequest request, HttpServletResponse response,
			Object ob, String uri, Dao dao) throws BibliotecaDaoExcepcion,IOException,ServletException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(HttpServletRequest request,
			HttpServletResponse response, Dao dao, String uri, Object ob) throws BibliotecaDaoExcepcion,IOException,ServletException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showForm(HttpServletRequest request,
			HttpServletResponse response, String uri, Object ob) throws IOException,ServletException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showList(HttpServletRequest request,
			HttpServletResponse response, Dao dao, String uri) throws BibliotecaDaoExcepcion,IOException,ServletException{
		dao.obtenerLista();
		
	}

	@Override
	public void update(HttpServletRequest request,
			HttpServletResponse response, Dao dao, String uri, Object obOld, Object obNew) throws BibliotecaDaoExcepcion,IOException,ServletException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getErrorExiste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorNoExiste() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
