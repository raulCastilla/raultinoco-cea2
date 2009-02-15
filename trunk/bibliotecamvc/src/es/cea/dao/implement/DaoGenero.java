package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Genero;

public class DaoGenero extends DaoAbstract<Genero>{

	@Override
	public List<Genero> getLista() {
		return BibliotecaDB.getInstance().getGeneros();
	}
	
}
