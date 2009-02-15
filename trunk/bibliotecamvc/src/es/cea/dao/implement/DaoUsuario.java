package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Usuario;

public class DaoUsuario extends DaoAbstract<Usuario>{

	@Override
	public List<Usuario> getLista() {
		return BibliotecaDB.getInstance().getUsuarios();
	}
	
}
