package es.cea;

public class Pregunta {
	protected Examen examen;
	protected Integer numeroPregunta;
	public Pregunta(Examen examen, Integer numeroPregunta) {
		super();
		this.examen = examen;
		this.numeroPregunta = numeroPregunta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		result = prime * result
				+ ((numeroPregunta == null) ? 0 : numeroPregunta.hashCode());
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
		Pregunta other = (Pregunta) obj;
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		if (numeroPregunta == null) {
			if (other.numeroPregunta != null)
				return false;
		} else if (!numeroPregunta.equals(other.numeroPregunta))
			return false;
		return true;
	}
	
}
