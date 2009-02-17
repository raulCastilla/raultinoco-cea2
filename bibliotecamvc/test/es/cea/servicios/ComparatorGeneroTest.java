package es.cea.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import es.cea.dao.modelo.Genero;
import es.cea.dao.modelo.Libro;

public class ComparatorGeneroTest {

	@Test
	public void comparaGeneros() {
		List<Libro> lista = new ArrayList<Libro>();
		Libro lib1 = new Libro("titulo1", "ref1", null, null, new Genero(
				"Aventuras"));
		Libro lib2 = new Libro("titulo2", "ref2", null, null, new Genero(
				"Romance"));
		lista.add(0, lib2);
		lista.add(1, lib1);
		
		Collections.sort(lista, new ComparatorGenero());
		assert (lista.indexOf(lib1) == 0) : "Debe estar el primero de la lista. El lugar es:"
				+ lista.indexOf(lib1);

	}

}
