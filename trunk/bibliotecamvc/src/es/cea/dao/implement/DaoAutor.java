package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Autor;
import es.cea.excepcion.BibliotecaDaoExcepcion;


public class DaoAutor extends DaoAbstract<Autor>{
	
	@Override
	public List<Autor> getLista() {
		return BibliotecaDB.getInstance().getAutores();
	}

	@Override
	public Autor obtener(Object o) throws BibliotecaDaoExcepcion {
		List<Autor> autor = getLista();
		
		String nombre=(String)o;
		
		Autor aut=null;
		for(Autor a:autor)
			if(a.getNombre().equals(nombre)) aut=a;
		return aut;
	}		
}
