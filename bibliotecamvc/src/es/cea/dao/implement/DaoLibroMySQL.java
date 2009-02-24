package es.cea.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Genero;
import es.cea.dao.modelo.Libro;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.FechaNoValidaException;
import es.cea.servicios.ServicioCalendario;

public class DaoLibroMySQL extends DaoAbstractMySQL implements Dao<Libro>{

	Dao<Genero> daoGenero;
	Dao<Autor> daoAutor;
	
	
	public DaoLibroMySQL(Dao<Genero> daoGenero, Dao<Autor> daoAutor) {
		super();
		this.daoGenero = daoGenero;
		this.daoAutor = daoAutor;
	}

	@Override
	public void agregar(Libro o) throws BibliotecaDaoExcepcion {
		ServicioCalendario cal = new ServicioCalendario();
		String fecha = cal.calendarioToString(o.getFechaPublicacion());
		String query = "insert into libros(referencia,titulo,autor,genero,fecha_publicacion) values(";
		String referencia = "'"+o.getReferencia()+"',";
		String titulo = "'"+o.getTitulo()+"',";
		String autor = "'"+o.getAutor().getNombre()+"',";
		String genero = "'"+o.getGenero().getNombre()+"',";
		String fechaPublicacion = "'"+fecha+"')";
		query+=referencia+titulo+autor+genero+fechaPublicacion;
		
		try {
			connection.createStatement().execute(query);
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}
	}

	@Override
	public void eliminar(Libro o) throws BibliotecaDaoExcepcion {
		String query = "delete from libros where referencia='"+o.getReferencia()+"'";
		try {
			connection.createStatement().executeUpdate(query);
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		}
		
	}

	@Override
	public Libro obtener(Object o) throws BibliotecaDaoExcepcion {
		
		String referencia = (String)o;
		String query = "select * from libros where referencia='"+referencia+"'";
		try {
			ResultSet consulta = connection.createStatement().executeQuery(query);
			if(consulta.next()){
				Libro libro = new Libro();
				ServicioCalendario cal = new ServicioCalendario();
				Calendar fecha = cal.stringToCalendario(consulta.getString("fecha_publicacion"));
				libro.setReferencia(consulta.getString("referencia"));
				libro.setTitulo(consulta.getString("titulo"));
				libro.setAutor(daoAutor.obtener(consulta.getString("autor")));
				libro.setGenero(daoGenero.obtener(consulta.getString("genero")));
				libro.setFechaPublicacion(fecha);
				return libro;
			}
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		} catch (FechaNoValidaException e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public List<Libro> obtenerLista() throws BibliotecaDaoExcepcion {
		List<Libro> libros = new ArrayList<Libro>();
		String query = "select * from libros";
		try {
			ResultSet consulta = connection.createStatement().executeQuery(query);
			while(consulta.next()){
				Libro libro = new Libro();
				ServicioCalendario cal = new ServicioCalendario();
				Calendar fecha = cal.stringToCalendario(consulta.getString("fecha_publicacion"));
				libro.setReferencia(consulta.getString("referencia"));
				libro.setTitulo(consulta.getString("titulo"));
				libro.setAutor(daoAutor.obtener(consulta.getString("autor")));
				libro.setGenero(daoGenero.obtener(consulta.getString("genero")));
				libro.setFechaPublicacion(fecha);
				libros.add(libro);
			}
		} catch (SQLException e) {
			throw new BibliotecaDaoExcepcion(e);
		} catch (FechaNoValidaException e) {
			e.getMessage();
		}
		return libros;
	}
	
}
