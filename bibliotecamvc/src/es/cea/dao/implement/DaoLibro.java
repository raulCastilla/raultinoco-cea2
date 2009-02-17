package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Libro;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoLibro extends DaoAbstract<Libro>{

	@Override
	public Libro obtener(Object o) throws BibliotecaDaoExcepcion {
		List<Libro> libros = getLista();
		
		String referencia=(String) o;

		Libro lib=null;
		for(Libro l:libros)
			if(l.getReferencia().equals(referencia)) lib=l;
		return lib;
	}

	@Override
	public List<Libro> getLista() {
		return BibliotecaDB.getInstance().getLibros();
	}
	
}
