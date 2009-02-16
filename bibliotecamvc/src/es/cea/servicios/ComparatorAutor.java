package es.cea.servicios;

import java.util.Comparator;
import es.cea.dao.modelo.Libro;


@SuppressWarnings("unchecked")
public class ComparatorAutor implements Comparator{

	public int compare(Object o1, Object o2) {
		Libro lib1 = (Libro)o1;
		Libro lib2 = (Libro)o2;
		if(lib1.getAutor().compareTo(lib2.getAutor())==0){
			return lib1.getTitulo().compareTo(lib2.getTitulo());
		}
		else{
			return lib1.getAutor().compareTo(lib2.getAutor());
		}
	}

	@Override
	public boolean equals(Object obj) {
		return this==obj;
	}
	
}
