package es.cea.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Libro;

public class ComparatorAutorTest {
	
	@Test
	public void comparaAutores(){
		List<Libro> lista = new ArrayList<Libro>();
		Libro lib1 = new Libro("titulo1", "ref1", null, new Autor("Antonio"), null);
		Libro lib2 = new Libro("titulo2", "ref2", null, new Autor("Ricardo"), null);
		lista.add(0, lib2);
		lista.add(1, lib1);
		
		Collections.sort(lista, new ComparatorAutor());
		assert(lista.indexOf(lib1)==0): "Debe estar el primero de la lista. El lugar es: "+lista.indexOf(lib1);
	}

}
