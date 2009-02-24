package es.cea.dao.implement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import es.cea.dao.modelo.Autor;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoAutorMySQLTest{
	@Test
	public void pruebaConexion() {
		DaoAutorMySQL dao = new DaoAutorMySQL();
		try {
			dao.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		} catch (Exception e) {
			assert (false);
		}
	}
	@Test
	public void pruebaGetAutores() throws BibliotecaDaoExcepcion{
		DaoAutorMySQL dao= new DaoAutorMySQL();
		dao.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		dao.executeImport("/resources/import.sql");
		
		List<Autor> autores =dao.obtenerLista();

		assert(autores!=null);
		assert(autores.size()==6);
	
	}
	
	@Test
	public void pruebaEliminarAutor() throws BibliotecaDaoExcepcion{
		DaoAutorMySQL dao = new DaoAutorMySQL();
		dao.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		dao.executeImport("/resources/import.sql");
		
		Autor autores = dao.obtener("autor1");
		dao.eliminar(autores);
		List<Autor> autor= dao.obtenerLista();
		assert(autor.size()==5);
		
		
	}
	
	@Test
	public void pruebaObtenerAutor() throws BibliotecaDaoExcepcion{
		DaoAutorMySQL dao = new DaoAutorMySQL();
		dao.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		dao.executeImport("/resources/import.sql");
	
		Autor autores = dao.obtener("autor1");
		assert(autores !=null);
		assert(autores.getNombre().equals("autor1"));
		
	}
	
	@Test
	public void pruebaInsertarAutor() throws BibliotecaDaoExcepcion{
		DaoAutorMySQL dao= new DaoAutorMySQL();
		dao.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		dao.executeImport("/resources/import.sql");
		
		
		Autor autor7 = new Autor("autor7");
		dao.agregar(autor7);
		List<Autor> autores= dao.obtenerLista();
		assert(autores.size()==7)
		;
		
		
		
		
	}
	
	
	

}