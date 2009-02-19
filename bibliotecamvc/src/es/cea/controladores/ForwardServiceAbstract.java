package es.cea.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public abstract class ForwardServiceAbstract {
	public ForwardServiceAbstract(){}
	
	public abstract void add(HttpServletRequest request,HttpServletResponse response, Object ob, String uri, Dao dao) throws BibliotecaDaoExcepcion,IOException,ServletException;
	public abstract void delete(HttpServletRequest request, HttpServletResponse response, Dao dao, String uri, Object ob) throws BibliotecaDaoExcepcion,IOException,ServletException;
	public abstract void update(HttpServletRequest request, HttpServletResponse response, Dao dao, String uri, Object obOld, Object obNew) throws BibliotecaDaoExcepcion,IOException,ServletException;
	public abstract void showList(HttpServletRequest request, HttpServletResponse response, Dao dao, String uri) throws BibliotecaDaoExcepcion,IOException,ServletException;
	public abstract void showForm(HttpServletRequest request, HttpServletResponse response, String uri, Object ob) throws IOException,ServletException;
	public abstract String getErrorList();
	public abstract String getErrorExiste();
	public abstract String getErrorNoExiste();
	
	public void forward(HttpServletRequest request, HttpServletResponse response, String uri) throws IOException,ServletException{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(uri);
		requestDispatcher.forward(request, response);
	}
}
