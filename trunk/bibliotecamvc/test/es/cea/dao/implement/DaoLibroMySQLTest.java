package es.cea.dao.implement;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Genero;
import es.cea.dao.modelo.Libro;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoLibroMySQLTest {
	DaoLibroMySQL daoLibroMySQL;
	@BeforeMethod
	public void iniciarRecursos() throws BibliotecaDaoExcepcion{
		/*Dao<Genero> daoGenero=new DaoGenero(){

			@Override
			public Genero obtener(Object o) throws BibliotecaDaoExcepcion {
				Genero genero=new Genero("");
				return genero;
			}
			
		};
		
		Dao<Autor> daoAutor=new DaoAutor(){

			@Override
			public Autor obtener(Object o) throws BibliotecaDaoExcepcion {
				Autor autor =new Autor("");
				
				return autor;
			}
			
		};*/
		DaoGeneroMySQL daoGenero = new DaoGeneroMySQL();
		DaoAutorMySQL daoAutor = new DaoAutorMySQL();
		daoGenero.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		daoAutor.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");

		 daoLibroMySQL=new DaoLibroMySQL(daoGenero, daoAutor);
		
	}
	
	@Test
	public void conecta(){
		try {
			daoLibroMySQL.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		} catch (BibliotecaDaoExcepcion e) {
			assert(false);

		}
			//daoLibroMySQL.executeImport("");
		
		
		
		
	}
	
	@Test
	public void obtenerLibros() throws BibliotecaDaoExcepcion{
		daoLibroMySQL.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		
		daoLibroMySQL.executeImport("/resources/import.sql");
		
		
		List<Libro> obtenerLista = daoLibroMySQL.obtenerLista();
			
		assert(obtenerLista!=null);
		assert(obtenerLista.size()==2);
		
		
		
		
		
	}
	@Test
	public void obtenerlibro()throws BibliotecaDaoExcepcion{
		daoLibroMySQL.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		daoLibroMySQL.executeImport("/resources/import.sql");
		Libro libro = daoLibroMySQL.obtener("ref001");
		assert(libro!=null);
	}
	
	@Test
	public void eliminarLibro() throws BibliotecaDaoExcepcion{
		daoLibroMySQL.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		daoLibroMySQL.executeImport("/resources/import.sql");
		
		
		Libro libro = new Libro(null,"ref001",null,null,null);
		daoLibroMySQL.eliminar(libro);
		List<Libro> obtenerLista = new ArrayList<Libro>();
		obtenerLista = daoLibroMySQL.obtenerLista();
		assert(obtenerLista.size()==1);
	}
	
	@Test
	public void agregarLibro() throws BibliotecaDaoExcepcion{
		daoLibroMySQL.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		daoLibroMySQL.executeImport("/resources/import.sql");
		Calendar cal = Calendar.getInstance();
		Libro libro = new Libro("title 3","ref003",cal,new Autor("autor1"),new Genero("genero1"));
		daoLibroMySQL.agregar(libro);
		List<Libro> obtenerLista = new ArrayList<Libro>();
		obtenerLista = daoLibroMySQL.obtenerLista();
		assert(obtenerLista.size()==3);
		
	}
}

