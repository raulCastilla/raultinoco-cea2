package es.cea.dao.implement;

import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoAutorTest {
	@Test
	public void agregarAutorLista() throws BibliotecaDaoExcepcion{
		Dao dao = new DaoAutor();
		Autor autor1 = new Autor("autor1");
		Autor autor2 = new Autor("autor2");
		Autor autor3 = new Autor("autor1");
		try{
			
			dao.agregar(autor1);
			dao.agregar(autor2);
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("No se ha podido realizar la operacio de agragar");
		}
			
		
		try{
			Boolean equals1 = dao.obtener(autor1).equals(dao.obtener(autor2));
			assert(!equals1):"deben ser distintos";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("No se ha podido obtener el elemento");
		}
		try{
			Boolean equals2 = dao.obtenerLista().size()==3;
			assert(equals2):"la lista debe contener tres elementos";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("No se ha podido obtener la lista");
		}
		try{
			dao.agregar(autor3);
			assert(false):"No se ha lanzado la excepcion";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("El elemento ya existe en la lista: "+autor3.getNombre());
			assert(true);
		}
		
	}
	
	@Test
	public void obtenerAutorLista(){
		Dao dao = new DaoAutor();
		Autor autor1 = new Autor("autor4");
		Autor autor3 = new Autor("autor5");
		
		try{
			dao.agregar(autor1);
			Boolean equals1 = dao.obtener(autor1).equals(autor1);
			assert(equals1):"el objeto devuelto debe ser el mismo";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("el elemento no existe en la lista");
		}
		
		try{
			dao.obtener(autor3);
			assert(false):"no se ha lanzado la excepcion";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("no existe ese elemento en la lista: "+autor3.getNombre());
			assert(true);
		}
		
	}
	
	@Test
	public void eliminarAutorLista(){
		Dao dao = new DaoAutor();
		Autor autor1 = new Autor("autor1");
		
		
		try{
			dao.eliminar(autor1);
			Boolean equals1 = dao.obtenerLista().size()==2;
			assert(equals1):"el numero de elementos deberia ser dos";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("no se ha podido eliminar el elemento");
		}
		
		try{
			
			dao.eliminar(autor1);
			assert(false):"no se ha lanzado la excepcion";
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("No se ha podido eliminar el elemento ya que no existe");
			assert(true);
		}
	}
}
