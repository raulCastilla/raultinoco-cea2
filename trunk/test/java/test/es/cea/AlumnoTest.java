package es.cea;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class AlumnoTest {
	
	@Test
	public void existeEnLista(){
		//Escenario de la prueba
		Alumno alumno1 = new Alumno("dn1","nombre1");
		Alumno alumno2 = new Alumno("dn2","nombre2");
		Alumno alumno3 = new Alumno("dn3","nombre3");
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		alumnos.add(alumno1);
		alumnos.add(alumno2);
		alumnos.add(alumno3);
		
		//Prueba 1
		boolean alumnoExiste=alumnos.contains(alumno1);
		assert(alumnoExiste):"este debe existir";
		
		//Modificamos el escenario
		Alumno alumno1BIS = new Alumno("dn1","PEPE");
		
		//Prueba 2
		boolean alumno1BisExiste=alumnos.contains(alumno1BIS);
		assert(alumno1BisExiste):"este tambien debe existir";
		
		//Modificamos el escenario
		int indexOf = alumnos.indexOf(alumno1BIS);
		
		//Prueba 3
		Alumno alumnoEncontrado = alumnos.get(indexOf);
		assert(alumnoEncontrado==alumno1);
	}
}
