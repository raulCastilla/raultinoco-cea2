package es.cea;

import java.io.Serializable;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	String nombre;
	String mail;
	String clave;
	Prestamo[] prestamos;
	Integer numPrestamo;
	Boolean registrado;
	Boolean permitido;
	
	public Usuario(String nombre, String mail,String clave) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.clave = clave;
		this.registrado=false;
		this.prestamos=new Prestamo[3];
		this.permitido=true;
		this.numPrestamo=0;
	}
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
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
		Usuario other = (Usuario) obj;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		return true;
	}
	
}
