package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Genero;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoGenero extends DaoAbstract<Genero>{

	@Override
	public List<Genero> getLista() {
		return BibliotecaDB.getInstance().getGeneros();
	}

	@Override
	public Genero obtener(Object o) throws BibliotecaDaoExcepcion {
		List<Genero> genero = getLista();
		
		String nombre = (String)o;
		Genero gen=null;
		for(Genero g:genero)
			if(g.getNombre().equals(nombre)) gen = g;
		return gen;
	}
	
}
