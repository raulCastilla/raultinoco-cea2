package es.cea;

import java.util.List;


	public interface Dao {
		public void agregar(Libro lib);
		public void eliminar(Libro lib);
//		public void modificar(Libro lib);
		public Libro obtener(Libro lib);
		
		public void agregar(Genero gen);
		public void eliminar(Genero gen);
//		public void modificar(Genero gen);
		public Genero obtener(Genero gen);
		
		public void agregar(Autor aut);
		public void eliminar(Autor aut);
//		public void modificar(Autor aut);
		public Autor obtener(Autor aut);
		
		public void agregar(Solicitud sol);
		public void eliminar(Solicitud sol);
//		public void modificar(Solicitud sol);
		public Solicitud obtener(Solicitud sol);
		
		public void agregar(Prestamo pre);
		public void eliminar(Prestamo pre);
//		public void modificar(Prestamo pre);
		public Prestamo obtener(Prestamo pre);
		
		public void agregar(Usuario user);
		public void eliminar(Usuario user);
//		public void modificar(Usuario user);
		public Usuario obtener(Usuario user);
		
		public List<Libro> obtenerListaLibros();
		public List<Genero> obtenerListaGeneros();
		public List<Autor> obtenerListaAutores();
	}
