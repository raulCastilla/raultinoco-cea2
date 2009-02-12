package es.cea.dao.implement;

import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Usuario;

public class DaoUsuario implements Dao<Usuario>{
	
	private List<Usuario> usuarios = BibliotecaDB.getInstance().getUsuarios();

	@Override
	public void agregar(Usuario o) {
		usuarios.add(o);
	}

	@Override
	public void eliminar(Usuario o) {
		usuarios.remove(o);
	}

	@Override
	public Usuario obtener(Usuario o) {
		if(usuarios.contains(o))
			return usuarios.get(usuarios.indexOf(o));
		else
			return null;
	}

	@Override
	public List<Usuario> obtenerLista() {
		return usuarios;
	}
	
}
