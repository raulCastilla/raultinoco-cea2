package es.cea.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Usuario;
import es.cea.dao.modelo.UsuarioAdministrador;
import es.cea.dao.modelo.UsuarioNoRegistrado;
import es.cea.dao.modelo.UsuarioRegistrado;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoUsuarioMySQL extends DaoAbstractMySQL implements Dao<Usuario> {

	@Override
	public void agregar(Usuario o) throws BibliotecaDaoExcepcion {
		try{
			connection.createStatement().execute("insert into usuario(mail_usuarios) values ('"+o.getCorreo()+"')");
			
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}		
	}

	@Override
	public void eliminar(Usuario o) throws BibliotecaDaoExcepcion {
		try {
			connection.createStatement().execute("delete from usuarios where mail_usuarios='"+o.getCorreo()+"'");
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}		
	}

	@Override
	public Usuario obtener(Object o) throws BibliotecaDaoExcepcion {
		String correo = (String)o;
		try {			
			ResultSet consulta = connection.createStatement().executeQuery("select * from usuarios where mail_usuarios='"+correo+"'");			
			if(consulta.next()){
				Usuario usuario;
				if(consulta.getInt("esAdministrador")>0){
					usuario = new UsuarioAdministrador(consulta.getString("nombre"),consulta.getString("mail"),consulta.getString("clave"));
				}
				else{
					if(consulta.getInt("esRegistrado")>0){
						usuario = new UsuarioRegistrado (consulta.getString("nombre"),consulta.getString("mail"),consulta.getString("clave"));
					}
					else{
						usuario = new UsuarioNoRegistrado (consulta.getString("nombre"),consulta.getString("mail"),consulta.getString("clave"));
					}
				}				
				return usuario;
			}
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}
		return null;
	}

	@Override
	public List<Usuario> obtenerLista() throws BibliotecaDaoExcepcion {
		List<Usuario> usuarios = new ArrayList<Usuario>();		
		try {
			
			ResultSet consulta = connection.createStatement().executeQuery("select * from usuarios");
			
			while(consulta.next()){				
				if(consulta.getInt("esAdministrador")>0){					
					Usuario usuario =new UsuarioAdministrador(consulta.getString("nombre"),consulta.getString("mail"),consulta.getString("clave"));
					usuarios.add(usuario);					
				}
				else{
					if(consulta.getInt("esRegistrado")>0){
						Usuario usuario =new UsuarioRegistrado(consulta.getString("nombre"),consulta.getString("mail"),consulta.getString("clave"));
						usuarios.add(usuario);
					}
					else{
						Usuario usuario =new UsuarioNoRegistrado (consulta.getString("nombre"),consulta.getString("mail"),consulta.getString("clave"));
						usuarios.add(usuario);
					}
				}
			}
		} 
		catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}
		return usuarios;
	}

}
