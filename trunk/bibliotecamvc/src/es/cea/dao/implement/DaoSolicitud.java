package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Solicitud;

public class DaoSolicitud extends DaoAbstract<Solicitud>{

	@Override
	public List<Solicitud> getLista() {
		return BibliotecaDB.getInstance().getSolicitudes();
	}

}
