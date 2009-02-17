package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.Dao;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public abstract class DaoAbstract<E> implements Dao<E>{

	
	abstract public List<E> getLista();



	@Override
	public void agregar(E o) throws BibliotecaDaoExcepcion {
		exceptionExistencia(o, false);
		getLista().add(o);
		
	}

	@Override
	public void eliminar(E o) throws BibliotecaDaoExcepcion {
		exceptionExistencia(o, true);
		getLista().remove(o);
		
	}

	@Override
	public E obtener(Object o) throws BibliotecaDaoExcepcion {
		exceptionExistencia(o, true);
		
		
		
		return getLista().get(getLista().indexOf(o));
	}

	@Override
	public List<E> obtenerLista() throws BibliotecaDaoExcepcion {
		exceptionListaNula();
		return getLista();
	}
	
	protected void exceptionExistencia(Object o, boolean debeexistir)
	throws BibliotecaDaoExcepcion {
		if (getLista().contains(o) != debeexistir)
			throw new BibliotecaDaoExcepcion();
	}
	
	protected void exceptionListaNula()
	throws BibliotecaDaoExcepcion{
		if(getLista()==null)
			throw new BibliotecaDaoExcepcion();
	}
}
