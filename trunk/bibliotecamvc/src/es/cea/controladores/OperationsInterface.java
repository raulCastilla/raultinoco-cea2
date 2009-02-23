package es.cea.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public interface OperationsInterface {
	public void add(Object ob, Dao dao) throws BibliotecaDaoExcepcion,Exception;
	public void delete(Dao dao, Object ob) throws BibliotecaDaoExcepcion;
	public void update(Dao dao, Object ob) throws BibliotecaDaoExcepcion,Exception;
}
