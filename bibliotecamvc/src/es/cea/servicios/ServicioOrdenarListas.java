package es.cea.servicios;

import java.util.Collections;
import java.util.List;
import es.cea.dao.modelo.Libro;

/**
 * Clase para que el usuario pueda ordenar las 
 * listas por autor o por genero.
 */

public class ServicioOrdenarListas {
	
	public List<Libro> ordenarPorAutor(List<Libro> lista, ComparatorAutor comparator){
		Collections.sort(lista, comparator);
		return lista;
		
	}
	
	public List<Libro> ordenarPorGenero(List<Libro> lista, ComparatorGenero comparator){
		Collections.sort(lista, comparator);
		return lista;
		
	}

}
