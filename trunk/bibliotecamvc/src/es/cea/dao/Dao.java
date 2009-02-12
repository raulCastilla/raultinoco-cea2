package es.cea.dao;

import java.util.List;

public interface Dao<E> {
	public void agregar(E o);
	public void eliminar(E o);
	public E obtener(E o);
	public List<E> obtenerLista();
}
