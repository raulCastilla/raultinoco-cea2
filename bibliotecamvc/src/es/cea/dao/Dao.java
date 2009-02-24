package es.cea.dao;

import java.util.List;

import es.cea.excepcion.BibliotecaDaoExcepcion;

public interface Dao<E> {
	public void agregar(E o) throws BibliotecaDaoExcepcion;
	public void eliminar(E o) throws BibliotecaDaoExcepcion;
	public E obtener(Object o) throws BibliotecaDaoExcepcion;
	public List<E> obtenerLista() throws BibliotecaDaoExcepcion;
	public void conecta(String url, String user, String password) throws BibliotecaDaoExcepcion;
}
