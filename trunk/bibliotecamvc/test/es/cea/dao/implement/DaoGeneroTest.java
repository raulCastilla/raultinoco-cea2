package es.cea.dao.implement;

import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Genero;

public class DaoGeneroTest {
	
	@Test
	public void agregarGeneroLista(){
		
		Dao dao = new DaoGenero();
		
		Genero gen1 = new Genero("gen1");
		Genero gen2 = new Genero("gen2");
		Genero gen3 = new Genero("gen1");
		
		dao.agregar(gen1);
		dao.agregar(gen2);
		dao.agregar(gen3);
		
		Boolean equals1 = dao.obtener(gen1).equals(gen2);
		assert(!equals1):"deben ser distintos";
		
		Boolean equals2 = dao.obtener(gen1).equals(gen3);
		assert(equals2):"deben ser iguales";
		
		Boolean equals3 = dao.obtenerLista().size()==2;
		assert(equals3):"debe ser 2 ya que no se pueden agregar dos genero iguales";
	}
	
	@Test
	public void obtenerGeneroLista(){
		Dao dao = new DaoGenero();
		
		Genero gen1 = new Genero("gen1");
		Genero gen2 = new Genero("gen1");
		
		dao.agregar(gen1);
		
		Boolean equals1=dao.obtener(gen2).equals(gen1);
		assert(equals1):"deben ser iguales";
		
	}
	
	@Test
	public void eliminarGeneroLista(){
		
		Dao dao = new DaoGenero();
		
		Genero gen1 = new Genero("gen1");
		Genero gen2 = new Genero("gen2");
		Genero gen3 = new Genero("gen3");
		
		dao.eliminar(gen1);
		
		Boolean equals1 = dao.obtenerLista().size()==2;
		assert(equals1):"el numero de elementos en la lista debe ser 2";
		
		Boolean equals2 = dao.obtener(gen1)==null;
		assert(equals2):"debe devolver nulo ya que el gen1 ha sido eliminado";
	}
}
