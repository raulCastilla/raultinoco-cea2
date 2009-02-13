package es.cea.dao.implement;

import java.util.List;


import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoAutor implements Dao<Autor>{
	private List<Autor> autores = BibliotecaDB.getInstance().getAutores();
	@Override
	public void agregar(Autor o) throws BibliotecaDaoExcepcion{
		if(!autores.contains(o))
			autores.add(o);
		else
			throw new BibliotecaDaoExcepcion();
	}

	@Override
	public void eliminar(Autor o) throws BibliotecaDaoExcepcion{
		if(autores.contains(o))
			autores.remove(o);
		else
			throw new BibliotecaDaoExcepcion();
	}

	@Override
	public Autor obtener(Autor o) throws BibliotecaDaoExcepcion{
		if(autores.contains(o))
			return autores.get(autores.indexOf(o));
		else
			throw new BibliotecaDaoExcepcion();
	}

	@Override
	public List<Autor> obtenerLista() throws BibliotecaDaoExcepcion{
		if(autores==null)
			throw new BibliotecaDaoExcepcion();
		else
			return autores;
	}
	
}
