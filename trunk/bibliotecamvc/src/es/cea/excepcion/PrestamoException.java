package es.cea.excepcion;

public class PrestamoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public PrestamoException (String mensaje){
		super(mensaje);
	}
}
