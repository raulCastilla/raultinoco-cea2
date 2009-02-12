package es.cea.dao.implement;
import java.util.List;


import es.cea.dao.Dao;
import es.cea.dao.modelo.Prestamo;

public class DaoPrestamo implements Dao<Prestamo>{
	
	private List<Prestamo> prestamos = BibliotecaDB.getInstance().getPrestamos();
	
	@Override
	public void agregar(Prestamo o) {
		prestamos.add(o);
	}

	@Override
	public void eliminar(Prestamo o) {
		prestamos.remove(o);
	}

	@Override
	public Prestamo obtener(Prestamo o) {
		if(prestamos.contains(o))
			return prestamos.get(prestamos.indexOf(o));
		else
			return null;
	}

	@Override
	public List<Prestamo> obtenerLista() {
		return prestamos;
	}

}
