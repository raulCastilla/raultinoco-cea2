package es.cea.excepcion;

public class BibliotecaDaoExcepcion extends Exception{

	public BibliotecaDaoExcepcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BibliotecaDaoExcepcion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BibliotecaDaoExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BibliotecaDaoExcepcion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "La operacion solicaitada no se ha podido realizar con exito";
	}
	
}
