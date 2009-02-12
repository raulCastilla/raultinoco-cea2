package es.cea;

public class Solicitud {
	private Usuario usuario;
	private Boolean aceptada;
	public Solicitud(Usuario usuario, Boolean aceptada) {
		super();
		this.usuario = usuario;
		this.aceptada = aceptada;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Boolean getAceptada() {
		return aceptada;
	}
	public void setAceptada(Boolean aceptada) {
		this.aceptada = aceptada;
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
