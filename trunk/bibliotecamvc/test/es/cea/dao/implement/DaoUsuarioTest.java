package es.cea.dao.implement;

import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Usuario;
import es.cea.dao.modelo.UsuarioRegistrado;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoUsuarioTest {
	private Dao dao = new DaoUsuario();;

	@Test
	public void agregarUsuarioLista(){
		
		UsuarioRegistrado us1 = new UsuarioRegistrado("us1","us1@mail.com","clave1");
		UsuarioRegistrado us2 = new UsuarioRegistrado("us2","us2@mail.com","clave2");
		UsuarioRegistrado us3 = new UsuarioRegistrado("us2","us2@mail.com","clave2");
		
		try{
			dao.agregar(us1);
			dao.agregar(us2);
			
			Boolean equals1 = dao.obtenerLista().size()==2;
			assert(equals1):"la lista debe tener dos elementos";
			
			Boolean equals2 = dao.obtener("us1@mail.com").equals(us1);
			assert(equals2):"debe ser el mismo usuario";
			
			Boolean equals3 = dao.obtener("us1@mail.com").equals(dao.obtener("us2@mail.com"));
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
	public void eliminarUsuarioLista(){
		UsuarioRegistrado us1 = new UsuarioRegistrado("us1","us1@mail.com","clave1");
		
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
