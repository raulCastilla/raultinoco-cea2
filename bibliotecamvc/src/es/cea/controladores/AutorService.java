package es.cea.controladores;

import java.util.Map;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class AutorService implements OperationsInterface{

	public void add(Object ob, Dao dao) throws BibliotecaDaoExcepcion,
			Exception {
		String nombre = (String)ob;
		dao.agregar(new Autor(nombre));
		
	}

	public void delete(Dao dao, Object ob) throws BibliotecaDaoExcepcion {
		String nombre = (String)ob;
		Autor autor = new Autor(nombre);
		dao.eliminar(autor);
		
	}

	public void update(Dao dao, Object ob) throws BibliotecaDaoExcepcion,
			Exception {
		Map valores = (Map)ob;
		String nameOld = dameValorPredeterminado(valores.get("nameOld"));
		String nameNew = dameValorPredeterminado(valores.get("nameNew"));
		Autor autor = (Autor) dao.obtener(nameOld);
		autor.setNombre(nameNew);
		
	}
	
	protected String dameValorPredeterminado(Object seleccion) {
		String[] v=(String[]) seleccion;
		return v[0];
	}
}
