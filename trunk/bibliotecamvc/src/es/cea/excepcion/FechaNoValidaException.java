package es.cea.excepcion;

public class FechaNoValidaException extends Exception{

	private static final long serialVersionUID = 1L;

	public FechaNoValidaException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FechaNoValidaException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FechaNoValidaException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FechaNoValidaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "La fecha no cumple el formato dd/MM/yyyy";
	}

}
