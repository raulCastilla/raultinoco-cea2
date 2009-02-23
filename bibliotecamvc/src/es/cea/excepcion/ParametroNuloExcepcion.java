package es.cea.excepcion;

public class ParametroNuloExcepcion extends Exception{

	public ParametroNuloExcepcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParametroNuloExcepcion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ParametroNuloExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ParametroNuloExcepcion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Existen par‡metors nulos";
	}

}
