package es.cea.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Solicitud;
import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoSolicitudMySQL extends DaoAbstractMySQL implements Dao<Solicitud> {
	Dao<Usuario> daoUsuario;
	
	public DaoSolicitudMySQL(Dao<Usuario> daoUsuario) {
		super();
		this.daoUsuario = daoUsuario;
	}

	@Override
	public void agregar(Solicitud o) throws BibliotecaDaoExcepcion {
		Integer aceptada = (o.getAceptada())?1:0;
		String query = "insert into solicitudes values('"+o.getUsuario().getCorreo()+"',"+aceptada+")";
		Usuario user = o.getUsuario();
		
		
		try {
			daoUsuario.agregar(user);
			connection.createStatement().execute(query);
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}
	}

	@Override
	public void eliminar(Solicitud o) throws BibliotecaDaoExcepcion {
		String query = "delete from solicitudes where mail='"+o.getUsuario().getCorreo()+"'";
		try {
			connection.createStatement().executeUpdate(query);
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}
	}

	@Override
	public Solicitud obtener(Object o) throws BibliotecaDaoExcepcion {
		String mail = (String)o;
		String query = "select * from solicitudes where mail='"+mail+"'";
		try {
			ResultSet consulta = connection.createStatement().executeQuery(query);
			if(consulta.next()){
				Solicitud solicitud = new Solicitud();
				solicitud.setUsuario(daoUsuario.obtener(consulta.getString("mail")));
				solicitud.setAceptada((consulta.getInt("aceptada")>0)?true:false);
				return solicitud;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BibliotecaDaoExcepcion(e);
		}
		return null;
	}

	@Override
	public List<Solicitud> obtenerLista() throws BibliotecaDaoExcepcion {
		List<Solicitud> solicitudes = new ArrayList<Solicitud>();
		
		String query = "select * from solicitudes";
		
		try {
			ResultSet consulta = connection.createStatement().executeQuery(query);
			while (consulta.next()) {
				Solicitud solicitud = new Solicitud();
				solicitud.setUsuario(daoUsuario.obtener(consulta.getString("mail")));
				solicitudes.add(solicitud);
			}
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}
		return solicitudes;
	}
	
}
