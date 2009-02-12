package es.cea.dao.implement;

import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;

public class DaoAutor implements Dao<Autor>{
	private List<Autor> autores = BibliotecaDB.getInstance().getAutores();
	@Override
	public void agregar(Autor o) {
		if(!autores.contains(o))
			autores.add(o);
	}

	@Override
	public void eliminar(Autor o) {
		if(autores.contains(o))
			autores.remove(o);
	}

	@Override
	public Autor obtener(Autor o) {
		if(autores.contains(o))
			return autores.get(autores.indexOf(o));
		else
			return null;
	}

	@Override
	public List<Autor> obtenerLista() {
		return autores;
	}
	
}
