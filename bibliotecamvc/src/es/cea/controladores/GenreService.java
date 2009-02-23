package es.cea.controladores;

import java.util.Map;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Genero;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class GenreService implements OperationsInterface{

	public void add(Object ob, Dao dao) throws BibliotecaDaoExcepcion,
			Exception {
		String nombre = (String)ob;
		dao.agregar(new Genero(nombre));
		
	}

	public void delete(Dao dao, Object ob) throws BibliotecaDaoExcepcion {
		String nombre = (String)ob;
		Genero gen = new Genero(nombre);
		dao.eliminar(gen);
		
	}

	public void update(Dao dao, Object ob) throws BibliotecaDaoExcepcion,
			Exception {
		Map valores = (Map)ob;
		String nameOld = dameValorPredeterminado(valores.get("nameOld"));
		String nameNew = dameValorPredeterminado(valores.get("nameNew"));
		Genero gen = (Genero)dao.obtener(nameOld);
		gen.setNombre(nameNew);
		
	}
	protected String dameValorPredeterminado(Object seleccion) {
		String[] v=(String[]) seleccion;
		return v[0];
	}
}
