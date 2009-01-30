package es.cea;

import java.io.Serializable;
import java.util.Calendar;

public class Prestamo implements Serializable{
	private static final long serialVersionUID = 1L;
	Libro libro;
	Usuario usuario;
	Calendar fechaInicio;
	Calendar fechaFin;
	
	public Prestamo(Libro libro, Usuario usuario) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fechaInicio = Calendar.getInstance();
		this.fechaFin = Calendar.getInstance();
		this.fechaFin.add(Calendar.DAY_OF_MONTH, +5);
	}
	
	public Integer diasRestantes(){
		Integer fin=this.fechaFin.get(this.fechaFin.DAY_OF_YEAR);
		Integer act=Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		return fin-act;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Prestamo other = (Prestamo) obj;
		if (fechaInicio == null) {
			if (other.fechaInicio != null)
				return false;
		} else if (!fechaInicio.equals(other.fechaInicio))
			return false;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}	
}
