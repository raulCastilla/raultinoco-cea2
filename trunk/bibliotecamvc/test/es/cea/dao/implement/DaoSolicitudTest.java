package es.cea.dao.implement;

import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Solicitud;
import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoSolicitudTest {
	
	
	@Test
	public void agregarSolicitudLista(){
		Dao dao = new DaoSolicitud();
		Usuario us1 = new Usuario("us1","us1@mail.com","clave1");
		Usuario us2 = new Usuario("us2","us2@mail.com","clave2");
		
		Solicitud sol1 = new Solicitud(us1);
		Solicitud sol2 = new Solicitud(us2);
		Solicitud sol3 = new Solicitud(us2);
		
		
		try{
			dao.agregar(sol1);
			dao.agregar(sol2);
			
			Boolean equals1 = dao.obtenerLista().size()==2;
			assert(equals1):"debe haber dos elementos en la lista";
			
			Boolean equals2 = dao.obtener(sol1).equals(dao.obtener(sol2));
			assert(!equals2):"deben ser distintos";
			
			dao.agregar(sol3);
			assert(false):"no se ha lanzado la excepcion";
			
			
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
			System.out.println("sol3 ya existe!!");
			assert(true);
		}
		
	}
	
	@Test
	public void obtenerSolicitudLista(){
		Dao dao = new DaoPrestamo();
		Usuario us3 = new Usuario("us3","us3@mail.com","clave3");
		Solicitud sol3 = new Solicitud(us3);
		
		try{
			
			dao.obtener(sol3);
			assert(false):"no se ha lanzado la excepcion";
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
			System.out.println("sol3 no existe en la lista");
			assert(true);
		}
		
	}
	
	@Test
	public void eliminarSolicitudLista(){
		Dao dao = new DaoSolicitud();
		Usuario us1 = new Usuario("us1","us1@mail.com","clave1");
		Solicitud sol1 = new Solicitud(us1);
		
		try{
			dao.eliminar(sol1);
			Boolean equals1 = dao.obtenerLista().size()==1;
			assert(equals1):"la lista solo deberia tener un elemento";
			
			dao.eliminar(sol1);
			assert(false):"no se ha lanzado la excepcion";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("sol1 no existe en la lista");
			assert(true);
			// TODO: handle exception
		}
	}
}
