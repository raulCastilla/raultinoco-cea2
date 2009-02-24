package es.cea.dao.implement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;
import es.cea.excepcion.BibliotecaDaoExcepcion;



public class DaoAutorMySQL extends DaoAbstractMySQL implements Dao<Autor>{
	

		@Override
		public void agregar(Autor o) throws BibliotecaDaoExcepcion {
			try{
				connection.createStatement().execute("insert into autor(nombre_autor) values ('"+o.getNombre()+"')");
				
			} catch (SQLException e) {
				throw new BibliotecaDaoExcepcion(e);
			}
}

		@Override
		public void eliminar(Autor o) throws BibliotecaDaoExcepcion {
			try {
				connection.createStatement().execute("delete from autor where nombre_autor='"+o.getNombre()+"'");
			} catch (SQLException e) {
				throw new BibliotecaDaoExcepcion(e);
			}
			
		}

		@Override
		public Autor obtener(Object o) throws BibliotecaDaoExcepcion {
			
			try {
				conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
				ResultSet consulta = connection.createStatement().executeQuery("select * from autor where nombre_autor='"+o+"'");
				if(consulta.next()){
					String nombre=consulta.getString("nombre_autor");
					Autor autor=new Autor(nombre);
					return autor;
				}
			} catch (SQLException e) {
				throw new BibliotecaDaoExcepcion(e);
			}
			return null;
		}

		@Override
		public List<Autor> obtenerLista() throws BibliotecaDaoExcepcion {
			List<Autor> autores = new ArrayList<Autor>();
			try {
//				conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
				ResultSet recordSet = connection.createStatement().executeQuery("select * from autor");
				while(recordSet.next()){
					String nombre=recordSet.getString("nombre_autor");
					Autor autor=new Autor(nombre);
					autores.add(autor);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new BibliotecaDaoExcepcion(e);
			}
			return autores;
		}
	
}
