package es.cea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Autor implements Serializable{
	private static final long serialVersionUID = 1L;
	String nombre;
	List<Libro> libros;
	
	public Autor(String nombre) {
		super();
		this.nombre = nombre;
		this.libros=new ArrayList<Libro>();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombre;
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
		Autor other = (Autor) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
