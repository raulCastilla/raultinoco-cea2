package es.cea.dao.implement;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import es.cea.dao.modelo.Genero;
import es.cea.excepcion.BibliotecaDaoExcepcion;


public class DaoGeneroMysqlTest {
	@Test
	public void pruebaConexion() {
		DaoGeneroMySQL dao = new DaoGeneroMySQL();
		try {
			dao.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		} catch (Exception e) {
			assert (false);
		}
	}
	
	@Test
	public void pruebaObtener() throws BibliotecaDaoExcepcion {
		DaoGeneroMySQL dao = new DaoGeneroMySQL();
		dao.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		dao.executeImport("/resources/import.sql");
		
		Genero genero = dao.obtener("novela");
		assert(genero!=null);
		assert(genero.getNombre().equals("novela"));
		
		Genero genero2 = dao.obtener("terror");
		assert(genero2.getNombre().equals("terror"));

	}
	
	@Test
	public void pruebaObtenerLista() throws BibliotecaDaoExcepcion {
		DaoGeneroMySQL dao = new DaoGeneroMySQL();
		dao.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		dao.executeImport("/resources/import.sql");
		
		List<Genero> generos = dao.obtenerLista();
		assert(generos!=null);
		assert(generos.size()==2);
	}
	
	@Test
	public void pruebaAgregarGenero() throws BibliotecaDaoExcepcion {
		DaoGeneroMySQL dao = new DaoGeneroMySQL();
		dao.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		dao.executeImport("/resources/import.sql");
		
		Genero genero4 = new Genero("genero4");
		dao.agregar(genero4);
		List<Genero> generos = dao.obtenerLista();
		assert(generos.size()==3);
	}
	
	@Test
	public void pruebaEliminarGenero() throws BibliotecaDaoExcepcion {
		DaoGeneroMySQL dao = new DaoGeneroMySQL();
		dao.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		dao.executeImport("/resources/import.sql");
		
		Genero genero3 = dao.obtener("terror");
		dao.eliminar(genero3);
		List<Genero> generos = dao.obtenerLista();
		assert(generos.size()==1);
	}
	
}
