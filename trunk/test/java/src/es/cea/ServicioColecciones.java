package es.cea;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ServicioColecciones {

	public void ordena(List lista) {
		Collections.sort(lista);		
	}

	public void ordena(List lista,
			Comparator comparator) {
		Collections.sort(lista, comparator);
		
	}

}
