package es.cea.conter;

import java.io.Serializable;

public class Contador implements Serializable{

	private static final long serialVersionUID = 1L;
	Integer visitas=0;
	Integer usuario=0;
	@Override
	public String toString() {
		return "Visitas: "+visitas.toString()+" Usuarios: "+usuario.toString();
	}
	
}
