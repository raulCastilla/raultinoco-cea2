package es.cea.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Genero;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoGeneroMySQL extends DaoAbstractMySQL implements Dao<Genero>{

	
	@Override
	public void agregar(Genero o) throws BibliotecaDaoExcepcion {
		try {
			connection.createStatement().execute("insert into genero(nombre_genero) values ('"+o.getNombre()+"')");	
		}catch (SQLException e){
			throw new BibliotecaDaoExcepcion(e);
		}
	}

	@Override
	public void eliminar(Genero o) throws BibliotecaDaoExcepcion {
		try {
			connection.createStatement().execute("delete from genero where nombre_genero='"+o.getNombre()+"'");
		} catch (SQLException e){
			throw new BibliotecaDaoExcepcion(e);
		}
	}

	@Override
	public Genero obtener(Object o) throws BibliotecaDaoExcepcion {
		String nombreGenero = (String) o;
		try {
			ResultSet consulta = connection.createStatement().executeQuery("select * from genero where nombre_genero='"+nombreGenero+"'");
			if(consulta.next()){
				Genero genero = new Genero(nombreGenero);
				genero.setNombre(consulta.getString("nombre_genero"));
				return genero;
			}
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}
		return null;
	}

	@Override
	public List<Genero> obtenerLista() throws BibliotecaDaoExcepcion {
		List<Genero> generos = new ArrayList<Genero>();
		try {
			ResultSet consulta = connection.createStatement().executeQuery("Select * from genero");
			while(consulta.next()){
				String nombre = consulta.getString("nombre_genero");
				Genero genero = new Genero(nombre);
				generos.add(genero);
			}
			
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}
		return generos;
	}

}
