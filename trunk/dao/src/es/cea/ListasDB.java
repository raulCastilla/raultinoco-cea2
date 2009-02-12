package es.cea;

import java.util.ArrayList;
import java.util.List;

public class ListasDB {
	private List<Genero> generos;
	private List<Libro> libros;
	private List<Autor> autores;
	private List<Usuario> usuarios;
	private List<Prestamo> prestamos;
	private List<Solicitud> solicitudes;
	
	private static ListasDB listaDB = new ListasDB();
	
	public static ListasDB getListasDB(){
		return listaDB;
	}
	
	private ListasDB(){
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

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
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
