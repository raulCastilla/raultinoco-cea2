package es.cea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.annotations.Test;

public class ColeccionesTest {
	
	@Test
	public void pruebaListas(){
		//Escenario de la prueba 
		Set<Alumno> alumnos=new HashSet<Alumno>();
		Alumno alumno1=new Alumno("1234","juan");
		Alumno alumno2=new Alumno("2345","pepe");
		Alumno alumno3=new Alumno("4567","luis");
		Alumno alumno1Bis=new Alumno("1234","juan");
		

		alumnos.add(alumno1);
		alumnos.add(alumno2);
		alumnos.add(alumno3);
		
		assert(alumnos.size()==3):"deberia ser el tamaño de la liste=3";
//		Prueba
		alumnos.add(alumno1Bis);
		assert(alumnos.size()==4):"El alumno repetido tambien se deberia incluir";
		
		
	}
}
