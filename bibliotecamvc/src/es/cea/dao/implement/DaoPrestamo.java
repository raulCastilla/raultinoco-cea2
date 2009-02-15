package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Prestamo;

public class DaoPrestamo extends DaoAbstract<Prestamo>{

	@Override
	public List<Prestamo> getLista() {
		return BibliotecaDB.getInstance().getPrestamos();
	}

}
