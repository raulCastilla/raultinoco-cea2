package es.cea;

import java.util.ArrayList;


import org.testng.annotations.Test;

public class DaoSimpleTest {
	Dao dao = new DaoSimple();
	
	Genero gen1 = new Genero("genero1", new ArrayList<Libro>());
	Genero gen2 = new Genero("genero2", new ArrayList<Libro>());
	Genero gen3 = new Genero("genero3", new ArrayList<Libro>());
	
	Autor aut1 = new Autor("autor1", new ArrayList<Libro>());
	Autor aut2 = new Autor("autor2", new ArrayList<Libro>());
	Autor aut3 = new Autor("autor3", new ArrayList<Libro>());
	
	Libro libro1 = new Libro("titulo1","ref1","10/10/2009",aut1,gen1);
	Libro libro2 = new Libro("titulo2","ref2","09/12/2000",aut2,gen2);
	Libro libro3 = new Libro("titulo3","ref3","03/03/1999",aut3,gen3);
	Libro libro1Bis = new Libro("titulo1","ref1","10/10/2009",aut1,gen1);
	@Test
	
	public void manipularLibro(){
		
		dao.agregar(libro1);
		assert(dao.obtener(libro1).equals(libro1)):"deben ser iguales";
		
		
		dao.agregar(libro2);
		assert(!dao.obtener(libro2).equals(libro1)):"deben ser distintos";
		
		
		dao.eliminar(libro1);
		assert(dao.obtener(libro1)==null):"debe devolver nulo";
		
		dao.agregar(libro1);
		dao.agregar(libro1Bis);
		assert(dao.obtenerListaLibros().size()==5):"debe haber cuatro libros";
		assert(dao.obtenerListaGeneros().size()==3):"Se esta agregando gen1 que ya existe";
		assert(dao.obtenerListaAutores().size()==3):"Se esta agregando aut1 que ya existe";
		
	}
	
	@Test
	public void manipularGenero(){
		
		dao.agregar(gen1);
		assert(dao.obtener(gen1).equals(gen1)):"deben ser iguales";
		
		dao.agregar(gen2);
		assert(!dao.obtener(gen1).equals(gen2)):"deben ser distintos";
		
		dao.eliminar(gen1);
		assert(dao.obtener(gen1)==null):"debe ser nulo";
	}
	
	@Test
	public void manipularAutor(){
		dao.agregar(aut1);
		assert(dao.obtener(aut1).equals(aut1)):"deben ser iguales";
		
		dao.agregar(aut2);
		assert(!dao.obtener(aut2).equals(aut1)):"deben ser distintos";
		
		dao.eliminar(aut1);
		assert(dao.obtener(aut1)==null):"debe ser nulo";
	}
	
	@Test
	public void comprobarListaLibrosDeUnGenero(){
		dao.agregar(libro3);
		assert(dao.obtener(gen3).getListaLibros().contains(libro3)):"en la lista de libros del genero debe estar el libro agregado";
		
	}
	
	@Test
	public void comprobarListaLibrosDeUnAutor(){
		dao.agregar(libro3);
		assert(dao.obtener(aut3).getListaLibros().contains(libro3)):"libro 3 debe estar en la lista de libros de aut3 ";
	}
}
