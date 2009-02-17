package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoUsuario extends DaoAbstract<Usuario>{

	@Override
	public List<Usuario> getLista() {
		return BibliotecaDB.getInstance().getUsuarios();
	}

	@Override
	public Usuario obtener(Object o) throws BibliotecaDaoExcepcion {
		List<Usuario> usuario = getLista();
		
		String mail = (String)o;
		Usuario user=null;
		for(Usuario u:usuario)
			if(u.getCorreo().equals(mail)) user=u;
		return user;
	}
	
}
