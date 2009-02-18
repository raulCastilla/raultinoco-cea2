package es.cea.dao.modelo;

public class UsuarioRegistrado extends Usuario{

	private static final long serialVersionUID = 1L;

	public UsuarioRegistrado(String nombre, String correo, String clve, Boolean registrado) {
		super(nombre, correo, clve, registrado);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Boolean isAdministrador() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Boolean isUsuarioRegistrado() {
		// TODO Auto-generated method stub
		return true;
	}
}
