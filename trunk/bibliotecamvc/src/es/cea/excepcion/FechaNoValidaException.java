package es.cea.excepcion;

public class FechaNoValidaException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "La fecha no cumple el formato dd/MM/yyyy";
	}

}
