package es.cea;

import java.io.Serializable;
import java.util.List;

public class Solicitud implements Serializable{
	private static final long serialVersionUID = 1L;
	Usuario usuario;
	List<Solicitud> solicitud;
	
	
	public Solicitud(Usuario usuario, List<Solicitud> solicitud) {
		super();
		this.usuario = usuario;
		this.solicitud = solicitud;
	}

	public void aceptar(){
		this.usuario.registrado=true;
	}
	
	public void denegar(){
		for(int i=0;i<this.solicitud.size();i++) if(solicitud.get(i).equals(this.usuario)) solicitud.remove(i);
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
