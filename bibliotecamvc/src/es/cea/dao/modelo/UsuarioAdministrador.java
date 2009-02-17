package es.cea.dao.modelo;

public class UsuarioAdministrador extends Usuario{

	private static final long serialVersionUID = 1L;

	@Override
	public Boolean isAdministrador() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean isUsuarioRegistrado() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
