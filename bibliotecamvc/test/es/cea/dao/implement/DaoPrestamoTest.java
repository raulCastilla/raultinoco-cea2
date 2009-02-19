package es.cea.dao.implement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.*;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.FechaNoValidaException;
import es.cea.servicios.ServicioCalendario;

public class DaoPrestamoTest {
	
	
	@BeforeMethod
	public void iniciarRecursos(){
		BibliotecaDB.reset();
	}
	
	@Test
	public void agregarPrestamoLista() throws FechaNoValidaException{
		Dao<Prestamo> dao = new DaoPrestamo();
		Autor aut1 = new Autor("aut1");
		Autor aut2 = new Autor("aut2");
		
		Genero gen1 = new Genero("gen1");
		Genero gen2 = new Genero("gen2");
		
		Libro lib1 = new Libro("titulo1","ref1",new ServicioCalendario().stringToCalendario("01/03/1999"),aut1,gen1);
		Libro lib2 = new Libro("titulo2","ref2",new ServicioCalendario().stringToCalendario("06/11/2007"),aut2,gen2);
		
		Usuario us1 = new UsuarioRegistrado("user1","user1@mail.com","clave1");
		Usuario us2 = new UsuarioRegistrado("user2","user2@mail.com","clave2");
		
		
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
	public void obtenerPrestamoLista() throws FechaNoValidaException, BibliotecaDaoExcepcion{
		Dao<Prestamo> daoPrestamo = new DaoPrestamo();
		
		
		Calendar fechaAltaPublicacion = new ServicioCalendario().stringToCalendario("06/11/2007");
		Calendar fechaInicioPrestamo = new ServicioCalendario().stringToCalendario("02/10/1999");
		Calendar fechaFinPrestamo = new ServicioCalendario().stringToCalendario("15/10/1999");
		
		Autor aut4 = new Autor("aut4");
		Genero gen4 = new Genero("gen4");
		UsuarioRegistrado us4 = new UsuarioRegistrado("user4","user4@mail.com","clave4");
		
		Libro lib4 = new Libro("titulo4","ref4",fechaAltaPublicacion,aut4,gen4);

		Prestamo prestamoEnDAO = new Prestamo(us4,lib4,fechaInicioPrestamo,fechaFinPrestamo);
		daoPrestamo.agregar(prestamoEnDAO);
		
		
			List<Object> identificativos= new ArrayList<Object>();
			identificativos.add(us4);
			identificativos.add(lib4);
			identificativos.add(fechaInicioPrestamo);
			identificativos.add(fechaFinPrestamo);
			Object resultadoBusqueda = daoPrestamo.obtener(identificativos);

			assert(resultadoBusqueda.equals(prestamoEnDAO));
			

	}
	
	@Test
	public void eliminarPrestamoLista() throws FechaNoValidaException{
		Dao<Prestamo> dao = new DaoPrestamo();
		Autor aut4 = new Autor("aut1");
		Genero gen4 = new Genero("gen1");
		UsuarioRegistrado us4 = new UsuarioRegistrado("user1","user1@mail.com","clave1");
		Libro lib4 = new Libro("titulo1","ref1",new ServicioCalendario().stringToCalendario("06/11/2007"),aut4,gen4);
		Prestamo pre4 = new Prestamo(us4,lib4,new ServicioCalendario().stringToCalendario("11/10/1999"),new ServicioCalendario().stringToCalendario("15/10/1999"));
		
		Autor aut5 = new Autor("aut45");
		Genero gen5 = new Genero("gen15");
		UsuarioRegistrado us5 = new UsuarioRegistrado("user15","user15@mail.com","clave15");
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
