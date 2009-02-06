package es.cea;

import java.util.Comparator;

public class AlumnoNombreComparator implements Comparator<Alumno> {

	public int compare(Alumno alumno1, Alumno alumno2) {
		// TODO Auto-generated method stub
		return alumno1.nombre.compareTo(alumno2.nombre);
	}

}
