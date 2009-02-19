package es.cea.dao.implement;

import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Genero;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoGeneroTest {
	
	@Test
	public void agregarGeneroLista()throws BibliotecaDaoExcepcion{
		
		Dao<Genero> dao = new DaoGenero();
		Genero gen2 = new Genero("gen2");
		Genero gen1 = new Genero("gen1");
		Genero gen3 = new Genero("gen1");
		
		try{
			dao.agregar(gen1);
			dao.agregar(gen2);
			
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
		}
		try{
			Boolean equals1 = dao.obtener("gen1").equals("gen2");
			assert(!equals1):"deben ser distintos";
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
		}
		try{
			Boolean equals2 = dao.obtener("gen1").equals(gen1);
			assert(equals2): "deben ser iguales";
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
		}
		try{
			Boolean equals3 = dao.obtenerLista().size()==2;
			assert(equals3):"debe ser 2 ya que no se pueden agregar dos genero iguales";
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void obtenerGeneroLista(){
		Dao<Genero> dao = new DaoGenero();
		
		Genero gen1 = new Genero("gen1");
		Genero gen4 = new Genero("gen4");
		
		try{
			Boolean equals1=dao.obtener("gen1").equals(gen1);
			assert(equals1):"deben ser iguales";
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void eliminarGeneroLista(){
		
		Dao<Genero> dao = new DaoGenero();
		
		Genero gen1 = new Genero("gen1");
		
		try{
			dao.eliminar(gen1);
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
		}
		try{
			Boolean equals1 = dao.obtenerLista().size()==1;
			assert(equals1):"el numero de elementos en la lista debe ser 1";
		}
		catch (BibliotecaDaoExcepcion e) {
			// TODO: handle exception
		}
		
		
	}
}
