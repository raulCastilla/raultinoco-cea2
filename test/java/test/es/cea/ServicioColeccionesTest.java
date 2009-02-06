package es.cea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;


public class ServicioColeccionesTest {

	
	@Test
	public void pruebaComportamientoMapasConClaveObjeto(){
		// en esta prueba se intenta demostrar el uso de objetos como claves y su repercusion en el equals /hashcode
		Alumno alumno1=new Alumno("dni1", null);
		Alumno alumno2=new Alumno("dni2", null);
		Alumno alumno1Bis=new Alumno("dni1", null);
		
		Map<Alumno, List<Curso>> mapa=new HashMap<Alumno, List<Curso>>(); 
		ArrayList<Curso> cursos1 = new ArrayList<Curso>();
		ArrayList<Curso> cursos2 = new ArrayList<Curso>();
		mapa.put(alumno1, cursos1);
		mapa.put(alumno2, cursos2);
		assert(mapa.containsKey(alumno1)):" debe contener el alumno 1";
		assert(mapa.containsKey(alumno1Bis)):" debe contener el alumno 1 bis ya que es igual al alumno1";
		
		List<Curso> listaCursos1 = mapa.get(alumno1Bis);
		assert(listaCursos1.equals(cursos1)):" con la clave de alumno debemos encontrar los cursos de este alumno";
		
		Curso curso=new Curso("nombre");
		listaCursos1.add(curso);
		
		assert(mapa.get(alumno1).get(0).equals(curso)):" comprobamos que efectivamente funciona la referencia";
		//en poo cuando trabajamos con un objeto/variable/instancia en realidad tenemos su referencia
		// esto se cumple siempre excepto en tipos primitivos! y cadenas
		
		
		
	}
	
	
	@Test
	public void pruebaOrdenarLista(){
		ServicioColecciones servicio=new ServicioColecciones();
		Alumno alumno1=new Alumno("dni1", "luis");
		Alumno alumno2=new Alumno("dni2", "antonio");
		Alumno alumno3=new Alumno("dni3", "pepe");
		
		List<Alumno> alumnos=new ArrayList<Alumno>();
		alumnos.add(alumno3);
		alumnos.add(alumno2);
		alumnos.add(alumno1);
		
		
		assert(alumnos.get(0).equals(alumno3)):" al principio el alumno 3 es el primero en la lista!";
		
		//ordenamos primero implementando la interfaz comparable en la clase alumno 
		servicio.ordena(alumnos);
		assert(alumnos.get(0).equals(alumno1)):" despues de implementar comparable por dni en alumo, el alumno 1 es el primero en la lista!";
		assert(alumnos.get(2).equals(alumno3)):" despues de implementar comparable por dni en alumo el ultimo alumno  de la lista es el tercero en la lista!";
		
		//ordenamos despues utilizando un objeto comparator que compara el nombre de los alumnos
		Comparator<Alumno>  comparadorAlumnoPorNombre=new AlumnoNombreComparator();
		servicio.ordena(alumnos, comparadorAlumnoPorNombre);
		assert(alumnos.get(0).equals(alumno2)):" despues de implementar comparator por nombre el alumno 2 es el primero en la lista!";
		assert(alumnos.get(1).equals(alumno1)):" despues de implementar comparator por nombre el alumno 1 es el segundo en la lista!";
		assert(alumnos.get(2).equals(alumno3)):" despues de implementar comparator por nombre el alumno 3 es el tercero en la lista!";
		
		
		
	}

	

	
	
	
	
	
	
	
}
