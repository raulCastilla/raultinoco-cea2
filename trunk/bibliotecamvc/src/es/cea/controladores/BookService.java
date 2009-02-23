package es.cea.controladores;

import java.util.Calendar;
import java.util.Map;

import es.cea.dao.Dao;
import es.cea.dao.implement.DaoAutor;
import es.cea.dao.implement.DaoGenero;
import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Genero;
import es.cea.dao.modelo.Libro;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.FechaNoValidaException;
import es.cea.servicios.ServicioCalendario;

public class BookService implements OperationsInterface{

	public void add(Object ob, Dao dao) throws BibliotecaDaoExcepcion, FechaNoValidaException {
		Libro lib;
		Map valores = (Map)ob;
		ServicioCalendario calService = new ServicioCalendario();
		Dao daoGenero = new DaoGenero();
		Dao daoAutor = new DaoAutor();
		
		String referencia = dameValorPredeterminado(valores.get("referencia"));
		String titulo = dameValorPredeterminado(valores.get("titulo"));
		String genero = dameValorPredeterminado(valores.get("genero"));
		String autor = dameValorPredeterminado(valores.get("autor"));
		String fecha = dameValorPredeterminado(valores.get("fecha"));
		
		Calendar fechaPublicacion = calService.stringToCalendario(fecha);
		
		Genero gen = new Genero(genero);
		Autor aut = new Autor(autor);
		Libro libro = new Libro(titulo,referencia,fechaPublicacion,aut,gen);
		
		dao.agregar(libro);
		
		try {
			daoGenero.agregar(gen);
			gen.getListaLibros().add(libro);
			
		} catch (BibliotecaDaoExcepcion e) {
			Genero genTemp = (Genero) daoGenero.obtener(gen.getNombre());
			genTemp.getListaLibros().add(libro);
		}
		
		try {
			daoAutor.agregar(aut);
			aut.getListaLibros().add(libro);
		} catch (BibliotecaDaoExcepcion e) {
			Autor autTemp = (Autor) daoAutor.obtener(aut.getNombre());
			autTemp.getListaLibros().add(libro);
		}
		
		
	}

	public void delete(Dao dao, Object ob) throws BibliotecaDaoExcepcion {
		String referencia = (String)ob;
		Libro libro = (Libro)dao.obtener(referencia);
		dao.eliminar(libro);
		
	}


	public void update(Dao dao, Object ob) throws BibliotecaDaoExcepcion,FechaNoValidaException {
		Map valores = (Map)ob;
		ServicioCalendario calService = new ServicioCalendario();
		String refOld = dameValorPredeterminado(valores.get("refOld"));
		String referencia = dameValorPredeterminado(valores.get("referencia"));
		String titulo = dameValorPredeterminado(valores.get("titulo"));
		String genero = dameValorPredeterminado(valores.get("genero"));
		String autor = dameValorPredeterminado(valores.get("autor"));
		String fecha = dameValorPredeterminado(valores.get("fecha"));
		
		Calendar fechaPublicacion = calService.stringToCalendario(fecha);
		Libro libro = (Libro)dao.obtener(refOld);
		
		libro.setReferencia(referencia);
		libro.getAutor().setNombre(autor);
		libro.getGenero().setNombre(genero);
		libro.setTitulo(titulo);
		libro.setFechaPublicacion(fechaPublicacion);
		
	}
	protected String dameValorPredeterminado(Object seleccion) {
		String[] v=(String[]) seleccion;
		return v[0];
	}
}
