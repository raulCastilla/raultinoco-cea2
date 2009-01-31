package es.cea;

import java.io.Serializable;
import java.util.Calendar;



public class Libro implements Serializable,Comparable{
	private static final long serialVersionUID = 1L;
	String referencia;
	String titulo;
	Genero genero;
	Autor autor;
	Boolean prestado;
	Calendar fechaPublicacion;
	
	public Libro(String referencia, String titulo, Genero genero, Autor autor, Integer date, Integer month, Integer year) {
		super();
		this.referencia = referencia;
		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
		this.prestado = false;
		this.fechaPublicacion = Calendar.getInstance();
		this.fechaPublicacion.set(year, month, date);
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((referencia == null) ? 0 : referencia.hashCode());
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
		Libro other = (Libro) obj;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}


	//Para utilizar este metodo hay que implementar la interfaz Comparable
	public int compareTo(Object o) {
		Libro libro = (Libro)o;
		return this.titulo.compareToIgnoreCase(libro.titulo); 
	}

	
	
	
}
