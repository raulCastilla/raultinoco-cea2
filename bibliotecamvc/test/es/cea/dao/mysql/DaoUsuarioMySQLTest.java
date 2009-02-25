package es.cea.dao.mysql;

import java.util.List;

import org.testng.annotations.Test;

import es.cea.dao.implement.DaoUsuarioMySQL;
import es.cea.dao.modelo.Usuario;
import es.cea.dao.modelo.UsuarioAdministrador;
import es.cea.dao.modelo.UsuarioNoRegistrado;
import es.cea.dao.modelo.UsuarioRegistrado;
import es.cea.excepcion.BibliotecaDaoExcepcion;





public class DaoUsuarioMySQLTest {
	
	@Test
	public void pruebaObtenerUsuarios() throws BibliotecaDaoExcepcion{
		
		DaoUsuarioMySQL daoUsuario = new DaoUsuarioMySQL();
		
		daoUsuario.resetDataBaseConImportSQL();
		
		List<Usuario> usuario = (List<Usuario>) daoUsuario.obtener(usuario);
		assert (usuario != null);
		
		Usuario user1 = new UsuarioAdministrador("nombre1","mail1","clave1");
		user1.setNombre("nombre1");
		user1.setCorreo("mail1");
		user1.setClave("clave1");
		assert (usuario.contains(user1)):"el usuario es administrador";
		
		Usuario user2 = new UsuarioNoRegistrado("nombre2","mail2","clave2");
		user2.setNombre("nombre2");
		user2.setCorreo("mail2");
		user2.setClave("clave2");
		assert (usuario.contains(user1)):"el usuario no esta registrado";
		
		Usuario user3 = new UsuarioRegistrado("nombre3","mail3","clave3");
		user3.setNombre("nombre3");
		user3.setCorreo("mail3");
		user3.setClave("clave3");
		assert (usuario.contains(user1)):"el usuario esta registrado";
	}
}
