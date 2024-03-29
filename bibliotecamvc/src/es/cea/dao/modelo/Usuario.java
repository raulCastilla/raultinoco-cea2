package es.cea.dao.modelo;

import java.io.Serializable;

import es.cea.dao.modelo.Prestamo;

public abstract class Usuario implements Serializable, Comparable<Usuario>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String correo;
	private String clave;
	private Boolean registrado;
	private Boolean permitido;
	
	private Integer numPrestamo;

	
	public Usuario(){
		
	}
	public Usuario(String nombre, String correo, String clave) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.clave = clave;
		this.registrado=false;
		this.permitido=false;
		
		this.numPrestamo=0;
		
	}
	
	public Integer getNumPrestamo(){
		return numPrestamo;
	}
	public void setNumPrestamo (Integer numP){
		this.numPrestamo=numP;
	}
	public Boolean getPermitido(){
		return permitido;
	}
	public void setPermitido (Boolean permi){
		this.permitido=permi;
	}
	
	public Boolean getRegistrado(){
		return registrado;
	}
	public void setRegistrado (Boolean regis){
		this.registrado=regis;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
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
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Usuario o) {
		return this.compareTo(o);
	}
	
	public abstract Boolean isAdministrador();
	public abstract Boolean isUsuarioRegistrado();
}
