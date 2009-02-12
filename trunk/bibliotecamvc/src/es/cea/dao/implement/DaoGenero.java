package es.cea.dao.implement;

import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Genero;

public class DaoGenero implements Dao<Genero>{
	
	private List<Genero> generos = BibliotecaDB.getInstance().getGeneros();
	
	@Override
	public void agregar(Genero o) {
		if(!generos.contains(o))
			generos.add(o);
	}

	@Override
	public void eliminar(Genero o) {
		if(generos.contains(o))
			generos.remove(o);
		
	}

	@Override
	public Genero obtener(Genero o) {
		if(generos.contains(o))
			return generos.get(generos.indexOf(o));
		else
			return null;
	}

	@Override
	public List<Genero> obtenerLista() {
		return generos;
	}

}
