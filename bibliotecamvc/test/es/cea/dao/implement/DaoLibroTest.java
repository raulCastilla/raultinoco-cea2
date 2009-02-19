package es.cea.dao.implement;

import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Libro;
import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Genero;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.FechaNoValidaException;
import es.cea.servicios.*;

public class DaoLibroTest {
	
	@Test
	public void agregarLibroLista() throws FechaNoValidaException{
		Dao dao = new DaoLibro();
		
		Autor aut1 = new Autor("aut1");
		Autor aut2 = new Autor("aut2");
		
		Genero gen1 = new Genero("gen1");
		Genero gen2 = new Genero("gen2");
		
		Libro lib1 = new Libro("titulo1","ref1",new ServicioCalendario().stringToCalendario("01/03/1999"),aut1,gen1);
		Libro lib2 = new Libro("titulo2","ref2",new ServicioCalendario().stringToCalendario("06/11/2007"),aut2,gen2);
		Libro lib3 = new Libro("titulo2","ref2",new ServicioCalendario().stringToCalendario("06/11/2007"),aut2,gen2);
		
		try{
			dao.agregar(lib1);
			dao.agregar(lib2);
			
			Boolean equals1 = dao.obtenerLista().size()==2;
			assert(equals1):"debe haber 2 elementos en la lista";
			
			Boolean equals2 = dao.obtener("ref1").equals(lib1);
			assert(equals2):"debe exisitir el lib1 en la lista";
			
			Boolean equals3 = dao.obtener("ref1").equals(lib2);
			assert(!equals3):"deben ser distintos";
			
			dao.agregar(lib3);
			assert(false):"no se ha lanzado la excepcion";
			
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println(lib3.getTitulo()+" ya existe!!");
			assert(true);
		}
	}
	
	
	@Test
	public void eliminarLibroLista() throws FechaNoValidaException{
		Dao dao = new DaoLibro();
		Autor aut1 = new Autor("aut1");
		Genero gen1 = new Genero("gen1");
		Libro lib1 = new Libro("titulo1","ref1",new ServicioCalendario().stringToCalendario("01/03/1999"),aut1,gen1);
		
		try{
			dao.eliminar(lib1);
			Boolean equals1 = dao.obtenerLista().size()==1;
			assert(equals1):"La lista debe contener un solo elemento";
			
			dao.obtener("lib1");
			assert(false):"no se ha lanzado la excepcion";
			
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println(lib1.getTitulo()+" no existe en la lista");
		}
		
	}
}
