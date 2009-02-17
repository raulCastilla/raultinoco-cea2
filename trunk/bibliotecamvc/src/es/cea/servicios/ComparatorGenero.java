package es.cea.servicios;

import java.util.Comparator;
import es.cea.dao.modelo.Libro;

@SuppressWarnings("unchecked")
public class ComparatorGenero implements Comparator{

	public int compare(Object o1, Object o2) {
		Libro lib1 = (Libro)o1;
		Libro lib2 = (Libro)o2;
		
		return lib1.getGenero().compareTo(lib2.getGenero());
	}

	

}
