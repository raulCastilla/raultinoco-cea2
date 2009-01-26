package es.cea.tienda;

public class ProductoNoExisteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProductoNoExisteException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductoNoExisteException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductoNoExisteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductoNoExisteException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		
		return getMessage();
	}

}
