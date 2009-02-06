package es.cea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class MapaAulasTest {
	@Test
	public void pruebaMapasAulas(){
		
		Localizacion local1 = new Localizacion("ref1",1);
		Localizacion local2 = new Localizacion("ref2",2);
		Localizacion local1Bis = new Localizacion("ref1",1);
		
		Aula aula1=new Aula(local1,"aula1");
		Aula aula2=new Aula(local2,"aula2");
		Aula aula1Bis=new Aula(local1,"aula1");
		Aula aula3 = new Aula(local2,"aula2");
		
		Alumno alumno1 = new Alumno("dn1","pepe");
		Alumno alumno2 = new Alumno("dn2","juan");
		
		
		List <Alumno> alumnos1=new ArrayList<Alumno>();
		List <Alumno> alumnos2=new ArrayList<Alumno>();
		List <Alumno> alumnos3=new ArrayList<Alumno>();
		
		alumnos1.add(alumno1);
		alumnos1.add(alumno2);
		
		alumnos2.add(alumno2);
		alumnos2.add(alumno1);
		
		
		Map <Aula,List<Alumno>> mapa1=new HashMap<Aula, List<Alumno>>();
		Map <Aula,List<Alumno>> mapa2=new HashMap<Aula, List<Alumno>>();
		
		mapa1.put(aula1, alumnos1);
		mapa1.put(aula2, alumnos2);

		mapa2.put(aula2, alumnos2);
		mapa2.put(aula1, alumnos1);
		
		
		//mapa.put(aula1Bis, alumnos1);
		//mapa.put(aula1Bis, alumnos2);
//		SI CON EL METODO PUT PONEMOS UNA CLAVE QUE YA EXISTE CON OTRO VALOR DISTINTO, ASIGNA EL NUEVO VALOR
//		A LA CLAVE EXISTENTE. SI LA CLAVE NO EXISTE, CREA UN NUEVO PAR CLAVE:VALOR
		
		Boolean equals1 = aula1.equals(aula2);
		assert(!equals1):"aula1 debe ser distinto a aula2";
		
		Boolean equals2 = aula1.equals(aula1Bis);
		assert(equals2):"aula1 debe ser igual a aula1Bis";
		
//		Boolean equals3 = mapa.containsKey(aula1);
//		assert(equals3):"la clave aula1 debe ser distinta a la clave aula2";
		
		
//		DOS LISTAS SON IGUALES SI CONTIENE LOS MISMOS ELEMENTOS EN EL MISMO ORDEN
		Boolean equals4 = mapa1.get(aula1).equals(mapa1.get(aula2));
		assert(!equals4):"DEBE SER FALSO";
		
//		Boolean equals5 = mapa.get(aula1Bis).equals(mapa.get(aula1));
//		assert(!equals5):"la referencia a las listas debe ser distintas";
		
		Boolean equals6 = mapa1.containsKey(aula3);
		assert(equals6):"DEBERIA CONTENER ESTA CLAVE";
	
//		DOS MAPAS SON IGUALES SI CONTIENEN LOS MISMOS PARES CLAVE VALOR, NO IMPORTA EL ORDEN		
		Boolean equals7 = mapa1.equals(mapa2);
		assert(equals7):"deberian ser iguales";
		
	}

}
