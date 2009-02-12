package es.cea.Dao;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaDB {
	private List<Genero> generos;
	private List<Libro> libros;
	private List<Autor> autores;
	private List<Usuario> usuarios;
	private List<Prestamo> prestamos;
	private List<Solicitud> solicitudes;
	
	public BibliotecaDB(){
		this.generos = new ArrayList<Genero>();
		this.libros = new ArrayList<Libro>();
		this.autores = new ArrayList<Autor>();
		this.usuarios = new ArrayList<Usuario>();
		this.prestamos = new ArrayList<Prestamo>();
		this.solicitudes = new ArrayList<Solicitud>();
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	
	
}
