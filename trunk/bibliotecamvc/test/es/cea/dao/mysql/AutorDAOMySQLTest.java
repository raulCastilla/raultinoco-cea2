package es.cea.dao.mysql;

import java.util.List;

import org.testng.annotations.Test;

import es.cea.excepcion.BibliotecaDaoExcepcion;

public class AutorDAOMySQLTest {

	@Test
	public void prueba() throws BibliotecaDaoExcepcion{
		AutorDAOMySQL dao=new AutorDAOMySQL();
		List autores = dao.obtenerLista();
		assert(autores!=null);
		
		
	}
	
}
