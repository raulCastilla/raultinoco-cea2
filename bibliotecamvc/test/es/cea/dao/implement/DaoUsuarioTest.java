package es.cea.dao.implement;

import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoUsuarioTest {
	private Dao dao = new DaoUsuario();;

	@Test
	public void agregarUsuarioLista(){
		
		Usuario us1 = new Usuario("us1","us1@mail.com","clave1");
		Usuario us2 = new Usuario("us2","us2@mail.com","clave2");
		Usuario us3 = new Usuario("us2","us2@mail.com","clave2");
		
		try{
			dao.agregar(us1);
			dao.agregar(us2);
			
			Boolean equals1 = dao.obtenerLista().size()==2;
			assert(equals1):"la lista debe tener dos elementos";
			
			Boolean equals2 = dao.obtener(us1).equals(us1);
			assert(equals2):"debe ser el mismo usuario";
			
			Boolean equals3 = dao.obtener(us1).equals(dao.obtener(us2));
			assert(!equals3):"deberian ser distintos";
			
			dao.agregar(us3);
			assert(false):"no se ha lanzado la excepcion";
			
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
			System.out.println("us3 ya existe en la lista");
			assert(true);
		}
	}
	@Test
	public void obtenerUsuarioLista(){
		Usuario us3 = new Usuario("us3","us3@mail.com","clave3");
		
		try{
			dao.obtener(us3);
			assert(false):"no se ha lanzado la excepcion";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("us3 no existe en la coleccion");
			assert(true);
		}
	}
	
	@Test
	public void eliminarUsuarioLista(){
		Usuario us1 = new Usuario("us1","us1@mail.com","clave1");
		
		try{
			dao.eliminar(us1);
			
			Boolean equals1 = dao.obtenerLista().size()==1;
			assert(equals1):"el numero de elementos en la lista debe ser uno";
			
			dao.eliminar(us1);
			assert(false):"no se ha lanzado la excepcio";
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
			System.out.println("us1 no existe en la lista");
			assert(true);
		}
	}
}
