package es.cea.dao.implement;

import java.util.List;
import java.util.Map;

import es.cea.dao.modelo.Prestamo;
import es.cea.dao.modelo.Solicitud;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoPrestamo extends DaoAbstract<Prestamo>{

	@Override
	public List<Prestamo> getLista() {
		return BibliotecaDB.getInstance().getPrestamos();
	}

	
	@Override
	public Prestamo obtener(Object o) throws BibliotecaDaoExcepcion {
		List<Prestamo> prestamo = getLista();
		Prestamo recibido=(Prestamo)o;
		Prestamo pre=null;
		for(Prestamo p:prestamo)
			if(p.equals(recibido)) pre=p;
		return pre;
		
	}
	
}
