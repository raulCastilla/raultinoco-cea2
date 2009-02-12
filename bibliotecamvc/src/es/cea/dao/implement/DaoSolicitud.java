package es.cea.dao.implement;

import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Solicitud;

public class DaoSolicitud implements Dao<Solicitud>{
	
	private List<Solicitud> solicitudes = BibliotecaDB.getInstance().getSolicitudes();
	
	@Override
	public void agregar(Solicitud o) {
		solicitudes.add(o);
	}

	@Override
	public void eliminar(Solicitud o) {
		solicitudes.remove(o);
	}

	@Override
	public Solicitud obtener(Solicitud o) {
		if(solicitudes.contains(o))
			return solicitudes.get(solicitudes.indexOf(o));
		else
			return null;
	}

	@Override
	public List<Solicitud> obtenerLista() {
		return solicitudes;
	}
	
}
