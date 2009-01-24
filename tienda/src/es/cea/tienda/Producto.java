package es.cea.tienda;

import java.io.Serializable;

public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	Integer id;
	Double precio;
	String nombre;
	public Producto(Integer id, Double precio, String nombre) {
		super();
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;
	}
}
