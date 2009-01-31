package es.cea;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class ComparatorAutor implements Comparator{

	public int compare(Object o1, Object o2) {
		Libro lib1 = (Libro)o1;
		Libro lib2 = (Libro)o2;
		if(lib1.autor.compareTo(lib2.autor)==0){
			return lib1.titulo.compareTo(lib2.titulo);
		}
		else{
			return lib1.autor.compareTo(lib2.autor);
		}
	}

	@Override
	public boolean equals(Object obj) {
		return this==obj;
	}
	
}
