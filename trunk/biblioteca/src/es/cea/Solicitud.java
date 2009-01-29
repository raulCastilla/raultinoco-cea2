package es.cea;

import java.io.Serializable;
import java.util.List;

public class Solicitud implements Serializable{
	private static final long serialVersionUID = 1L;
	Usuario usuario;
	List<Solicitud> solicitud;
	List<Usuario> listaUsuarios;
	
	
	public Solicitud(Usuario usuario, List<Solicitud> solicitud, List<Usuario> listaUsuarios) {
		super();
		this.usuario = usuario;
		this.solicitud = solicitud;
		this.listaUsuarios = listaUsuarios;
	}

	public void aceptar(){
		this.usuario.registrado=true;
	}
	
	public void denegar(){
		//Borrar la esta solicitud de la lsta
		for(int i=0;i<this.solicitud.size();i++){ 
			if(solicitud.get(i).equals(this)) solicitud.remove(i);
		}
		//Borrar el usuario de la lista de usuarios
		for(int j=0;j<this.listaUsuarios.size();j++){
			if(this.listaUsuarios.get(j).equals(this.usuario)) listaUsuarios.remove(j);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Solicitud other = (Solicitud) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}
