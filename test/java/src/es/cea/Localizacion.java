package es.cea;

public class Localizacion {
	protected String referencia;
	protected Integer planta;
	public Localizacion(String referencia, Integer planta) {
		super();
		this.referencia = referencia;
		this.planta = planta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((planta == null) ? 0 : planta.hashCode());
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
		Localizacion other = (Localizacion) obj;
		if (planta == null) {
			if (other.planta != null)
				return false;
		} else if (!planta.equals(other.planta))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}
	
	
}
