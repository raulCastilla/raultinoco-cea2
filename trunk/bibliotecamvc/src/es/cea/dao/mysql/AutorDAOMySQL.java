package es.cea.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class AutorDAOMySQL implements Dao<Autor> {

	public AutorDAOMySQL() {
		Connection conexion = abreConexion();
		try {
			conexion.createStatement().executeUpdate( "CREATE DATABASE IF NOT EXISTS biblioteca;");
			conexion.createStatement().executeUpdate( "USE biblioteca;");
			conexion.createStatement().executeUpdate( "DROP TABLE IF EXISTS autores; ");
			conexion.createStatement().executeUpdate( "CREATE TABLE autores " +
													"(nombre varchar(45) NOT NULL,PRIMARY KEY  (nombre)) " +
													"ENGINE=MyISAM DEFAULT CHARSET=latin1;");
			
			
			
			conexion.createStatement().execute("insert into autores(nombre) values('autor 1')");
			conexion.createStatement().execute("insert into autores(nombre) values('autor 2')");
			conexion.createStatement().execute("insert into autores(nombre) values('autor 3')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		cierraConexion(conexion);

	}

	@Override
	public void agregar(Autor o) throws BibliotecaDaoExcepcion {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Autor o) throws BibliotecaDaoExcepcion {
		// TODO Auto-generated method stub

	}

	@Override
	public Autor obtener(Object o) throws BibliotecaDaoExcepcion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Autor> obtenerLista() throws BibliotecaDaoExcepcion {
		List<Autor> autores = new ArrayList<Autor>();
		try {
			Connection conexion = abreConexion();
			Statement createStatement = conexion.createStatement();
			ResultSet recordSet = createStatement
					.executeQuery("select * from autores");
			while (recordSet.next()) {
				String nombre = recordSet.getString("nombre");
				// new Autor("");
				Autor autor = new Autor(nombre);
				autores.add(autor);

			}
			cierraConexion(conexion);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new BibliotecaDaoExcepcion(e);
		}
		return autores;
	}

	private void cierraConexion(Connection conexion) {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private Connection abreConexion() {
		Connection conexion = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/biblioteca", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}
		return conexion;
	}

}
