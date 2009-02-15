package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Autor;


public class DaoAutor extends DaoAbstract<Autor>{
	
	@Override
	public List<Autor> getLista() {
		return BibliotecaDB.getInstance().getAutores();
	}

	
}
