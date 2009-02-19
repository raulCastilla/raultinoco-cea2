package es.cea.dao.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Genero implements Serializable, Comparable<Genero>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private List<Libro> listaLibros;
	public Genero(String nombre) {
		super();
		this.nombre = nombre;
		this.listaLibros = new ArrayList<Libro>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Libro> getListaLibros() {
		return listaLibros;
	}
	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public int compareTo(Genero o) {
		return this.nombre.compareTo(o.nombre);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Genero: "+nombre;
	}
	
}
