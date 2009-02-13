package es.cea.dao.implement;

import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;

public class DaoAutorTest {
	@Test
	public void agregarAutorLista(){
		Dao dao = new DaoAutor();
		Autor autor1 = new Autor("autor1");
		Autor autor2 = new Autor("autor2");
		Autor autor3 = new Autor("autor1");
		
		dao.agregar(autor1);
		dao.agregar(autor2);
		dao.agregar(autor3);
		
		
		Boolean equals1 = dao.obtener(autor1).equals(dao.obtener(autor2));
		assert(!equals1):"deben ser distintos";
		
		Boolean equals2 = dao.obtenerLista().size()==2;
		assert(equals2):"debe ser 2 ya que no agrega un autor si ya existe";
		
	}
	
	@Test
	public void obtenerAutorLista(){
		Dao dao = new DaoAutor();
		Autor autor1 = new Autor("autor1");
		Autor autor3 = new Autor("autor1");
		
		dao.agregar(autor1);
		
		Boolean equals1 = dao.obtener(autor3).equals(autor1);
		assert(equals1):"el objeto devuelto debe ser el mismo";
	}
	@Test
	public void eliminarAutorLista(){
		Dao dao = new DaoAutor();
		Autor autor1 = new Autor("autor1");
		Autor autor2 = new Autor("autor2");
		Autor autor3 = new Autor("autor3");
		
		dao.agregar(autor1);
		dao.agregar(autor2);
		dao.agregar(autor3);
		
		dao.eliminar(autor3);
		Boolean equals1 = dao.obtenerLista().size()==2;
		assert(equals1):"el numero de elementos deberia ser dos";
		
		Boolean equals2 = dao.obtener(autor3)==null;
		assert(equals2):"debe devolver null en caso de que no exista";
	}
}
