package es.cea.dao.modelo;

public class UsuarioNoRegistrado extends Usuario{

	public UsuarioNoRegistrado(String nombre, String correo, String clve,Boolean registrado) {
		super(nombre, correo, clve, registrado);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Override
	public Boolean isAdministrador() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean isUsuarioRegistrado() {
		// TODO Auto-generated method stub
		return false;
	}

}
