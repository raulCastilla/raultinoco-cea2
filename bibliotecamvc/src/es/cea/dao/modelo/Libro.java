package es.cea.dao.modelo;

import java.io.Serializable;
import java.util.Calendar;


public class Libro implements Serializable, Comparable<Libro>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String referencia;
	private Calendar fechaPublicacion;
	private Autor autor;
	private Genero genero;
	private Boolean prestado;
	public Libro(){}
	public Libro(String titulo, String referencia, Calendar fechaPublicacion,
			Autor autor, Genero genero) {
		super();
		this.titulo = titulo;
		this.referencia = referencia;
		this.fechaPublicacion = fechaPublicacion;
		this.autor = autor;
		this.genero = genero;
		this.prestado = false;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Calendar getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Calendar fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Boolean getPrestado() {
		return prestado;
	}
	public void setPrestado(Boolean prestado) {
		this.prestado = prestado;
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
	@Override
	public int compareTo(Libro o) {
		return this.referencia.compareTo(o.referencia);
	}
	
}
