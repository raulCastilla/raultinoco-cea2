package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Libro;

public class DaoLibro extends DaoAbstract<Libro>{

	@Override
	public List<Libro> getLista() {
		return BibliotecaDB.getInstance().getLibros();
	}
	
}
