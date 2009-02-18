package es.cea.dao.implement;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import es.cea.dao.modelo.Libro;
import es.cea.dao.modelo.Prestamo;
import es.cea.dao.modelo.Solicitud;
import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoPrestamo extends DaoAbstract<Prestamo>{

	@Override
	public List<Prestamo> getLista() {
		return BibliotecaDB.getInstance().getPrestamos();
	}

	
	@Override
	public Prestamo obtener(Object o) throws BibliotecaDaoExcepcion {
		List<Prestamo> prestamo = getLista();
		List<Object> recibido=(List<Object>)o;
		
		Usuario usuario=(Usuario) recibido.get(0);
		Libro libro=(Libro) recibido.get(1);
		Calendar inicio=(Calendar) recibido.get(2);
		Calendar fin=(Calendar) recibido.get(3);
 		
		
		Prestamo prestamoFicticio=new Prestamo(usuario, libro, inicio, fin);
		
		Prestamo pre=null;
		for(Prestamo p:prestamo)
			if(p.equals(prestamoFicticio)) pre=p;
		return pre;
		
	}
	
}
