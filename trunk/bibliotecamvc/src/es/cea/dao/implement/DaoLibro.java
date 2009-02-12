package es.cea.dao.implement;

import java.util.List;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Genero;
import es.cea.dao.modelo.Libro;

public class DaoLibro implements Dao<Libro>{
	
	private List<Libro> libros = BibliotecaDB.getInstance().getLibros();
	private List<Genero> generos = BibliotecaDB.getInstance().getGeneros();
	private List<Autor> autores = BibliotecaDB.getInstance().getAutores();
	
	@Override
	public void agregar(Libro o) {
		libros.add(o);
		if(!generos.contains(o.getGenero()))
			generos.add(o.getGenero());
		o.getGenero().getListaLibros().add(o);
		if(!autores.contains(o.getAutor()))
			autores.add(o.getAutor());
		o.getAutor().getListaLibros().add(o);
	}

	@Override
	public void eliminar(Libro o) {
		libros.remove(o);
	}

	@Override
	public Libro obtener(Libro o) {
		if(libros.contains(o))
			return libros.get(libros.indexOf(o));
		else
			return null;
	}

	@Override
	public List<Libro> obtenerLista() {
		return libros;
	}
	
}
