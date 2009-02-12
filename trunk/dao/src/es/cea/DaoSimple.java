package es.cea;

import java.util.ArrayList;
import java.util.List;


public class DaoSimple implements Dao{
	private List<Libro> libros;
	private List<Genero> generos;
	private List<Autor> autores;
	

	public DaoSimple() {
		super();
		this.libros = new ArrayList<Libro>();
		this.generos = new ArrayList<Genero>();
		this.autores = new ArrayList<Autor>();
	}

	public void agregar(Autor aut) {
		this.autores.add(aut);
		
	}

	public void agregar(Genero gen) {
		this.generos.add(gen);
	}

	public void agregar(Libro lib) {
		this.libros.add(lib);
		if(!this.obtenerListaGeneros().contains(lib.getGenero()))
			this.agregar(lib.getGenero());
		this.obtener(lib.getGenero()).getListaLibros().add(lib);
		if(!this.obtenerListaAutores().contains(lib.getAutor()))
			this.agregar(lib.getAutor());
		this.obtener(lib.getAutor()).getListaLibros().add(lib);
	}

	public void agregar(Prestamo pre) {
		// TODO Auto-generated method stub
		
	}

	public void agregar(Solicitud sol) {
		// TODO Auto-generated method stub
		
	}

	public void agregar(Usuario user) {
		// TODO Auto-generated method stub
		
	}

	public void eliminar(Autor aut) {
		if(autores.contains(aut))
			autores.remove(aut);
		
	}

	public void eliminar(Genero gen) {
		if(generos.contains(gen))
			generos.remove(gen);
		
	}

	public void eliminar(Libro lib) {
		if(libros.contains(lib))
			libros.remove(lib);
		
	}

	public void eliminar(Prestamo pre) {
		// TODO Auto-generated method stub
		
	}

	public void eliminar(Solicitud sol) {
		// TODO Auto-generated method stub
		
	}

	public void eliminar(Usuario user) {
		// TODO Auto-generated method stub
		
	}
/*
	public void modificar(Autor aut) {
		// TODO Auto-generated method stub
		
	}

	public void modificar(Genero gen) {
		// TODO Auto-generated method stub
		
	}

	public void modificar(Libro lib) {
		// TODO Auto-generated method stub
		
	}

	public void modificar(Prestamo pre) {
		// TODO Auto-generated method stub
		
	}

	public void modificar(Solicitud sol) {
		// TODO Auto-generated method stub
		
	}

	public void modificar(Usuario user) {
		// TODO Auto-generated method stub
		
	}
*/
	public Autor obtener(Autor aut) {
		if(autores.contains(aut))
			return autores.get(autores.indexOf(aut));
		else
			return null;
	}

	public Genero obtener(Genero gen) {
		if(generos.contains(gen))
			return generos.get(generos.indexOf(gen));
		else
			return null;
	}

	public Libro obtener(Libro lib) {
		if(libros.contains(lib))
			return libros.get(libros.indexOf(lib));
		else
			return null;
	}

	public Prestamo obtener(Prestamo pre) {
		return null;
	}

	public Solicitud obtener(Solicitud sol) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario obtener(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<Autor> obtenerListaAutores() {
		return this.autores;
	}

	public List<Genero> obtenerListaGeneros() {
		return this.generos;
	}

	public List<Libro> obtenerListaLibros() {
		return this.libros;
	}
	
}
