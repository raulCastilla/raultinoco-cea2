package es.cea.dao.implement;

import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.*;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.FechaNoValidaException;
import es.cea.servicios.ServicioCalendario;

public class DaoPrestamoTest {
	@Test
	public void agregarPrestamoLista() throws FechaNoValidaException{
		Dao dao = new DaoPrestamo();
		Autor aut1 = new Autor("aut1");
		Autor aut2 = new Autor("aut2");
		
		Genero gen1 = new Genero("gen1");
		Genero gen2 = new Genero("gen2");
		
		Libro lib1 = new Libro("titulo1","ref1",new ServicioCalendario().stringToCalendario("01/03/1999"),aut1,gen1);
		Libro lib2 = new Libro("titulo2","ref2",new ServicioCalendario().stringToCalendario("06/11/2007"),aut2,gen2);
		
		Usuario us1 = new Usuario("user1","user1@mail.com","clave1");
		Usuario us2 = new Usuario("user2","user2@mail.com","clave2");
		
		
		Prestamo pre1 = new Prestamo(us1,lib1,new ServicioCalendario().stringToCalendario("11/10/1999"),new ServicioCalendario().stringToCalendario("15/10/1999"));
		Prestamo pre2 = new Prestamo(us2,lib2,new ServicioCalendario().stringToCalendario("11/10/1999"),new ServicioCalendario().stringToCalendario("15/10/1999"));
		Prestamo pre3 = new Prestamo(us2,lib2,new ServicioCalendario().stringToCalendario("11/10/1999"),new ServicioCalendario().stringToCalendario("15/10/1999"));
		
		try{
			dao.agregar(pre1);
			dao.agregar(pre2);
			
			Boolean equals1 = dao.obtenerLista().size()==2;
			assert(equals1):"la lista deberia tener 2 elementos";
			
			Boolean equals2 = dao.obtener(pre1).equals(pre1);
			assert(equals2):"debe ser igual a pre1";
			
			Boolean equals3 = dao.obtener(pre1).equals(dao.obtener(pre2));
			assert(!equals3):"pre1 debe ser distinto de pre2";
			
			dao.agregar(pre3);
			assert(false):"no se ha lanzado la excepcion";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("pre3 ya existe en la lista");
			assert(true);
			// TODO: handle exception
		}
	}
	
	@Test
	public void obtenerPrestamoLista() throws FechaNoValidaException{
		Dao dao = new DaoPrestamo();
		Autor aut4 = new Autor("aut4");
		Genero gen4 = new Genero("gen4");
		Usuario us4 = new Usuario("user4","user4@mail.com","clave4");
		Libro lib4 = new Libro("titulo4","ref4",new ServicioCalendario().stringToCalendario("06/11/2007"),aut4,gen4);
		Prestamo pre4 = new Prestamo(us4,lib4,new ServicioCalendario().stringToCalendario("02/10/1999"),new ServicioCalendario().stringToCalendario("15/10/1999"));
		
		try{
			
			dao.obtener(pre4);
			assert(false):"no se ha lanzado la excepcion";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("pre4 no existe en la lista");
			assert(true);
			// TODO: handle exception
		}
	}
	
	@Test
	public void eliminarPrestamoLista() throws FechaNoValidaException{
		Dao dao = new DaoPrestamo();
		Autor aut4 = new Autor("aut1");
		Genero gen4 = new Genero("gen1");
		Usuario us4 = new Usuario("user1","user1@mail.com","clave1");
		Libro lib4 = new Libro("titulo1","ref1",new ServicioCalendario().stringToCalendario("06/11/2007"),aut4,gen4);
		Prestamo pre4 = new Prestamo(us4,lib4,new ServicioCalendario().stringToCalendario("11/10/1999"),new ServicioCalendario().stringToCalendario("15/10/1999"));
		
		Autor aut5 = new Autor("aut45");
		Genero gen5 = new Genero("gen15");
		Usuario us5 = new Usuario("user15","user15@mail.com","clave15");
		Libro lib5 = new Libro("titulo5","ref5",new ServicioCalendario().stringToCalendario("06/11/2007"),aut5,gen5);
		Prestamo pre5 = new Prestamo(us5,lib5,new ServicioCalendario().stringToCalendario("14/10/1999"),new ServicioCalendario().stringToCalendario("15/10/1999"));
		try{
			
			dao.eliminar(pre4);
			Boolean equals1 = dao.obtenerLista().size()==1;
			assert(equals1):"la lista debe contener un solo elemento";
			
			dao.eliminar(pre5);
			assert(false):"no se ha lanzado la excepcion";
			
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
			System.out.println("ese elemento no existe en la lista");
			assert(true);
		}
	}
}
