package es.cea;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrearLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Genero> genero=(List<Genero>)request.getSession().getServletContext().getAttribute(AtributosConstantes.generos.toString());
		List<Libro> libro=(List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		List<Autor> autor=(List<Autor>)request.getSession().getServletContext().getAttribute(AtributosConstantes.autores.toString());
		
		Autor aut = new Autor(request.getParameter("autor"));
		Genero gen = new Genero(request.getParameter("genero"));
		Libro lib= new Libro("RFC-1314","El libro de la selva",gen,aut);
		
		if(!genero.contains(gen)){ 
			gen.libros.add(lib);
			genero.add(gen);
		}
		else{
			Genero g=null;
			for(Genero tmp:genero) if(tmp.nombre.equals(request.getParameter("genero"))) g=tmp;
			g.libros.add(lib);
		}
		if(!autor.contains(aut)){ 
			aut.libros.add(lib);
			autor.add(aut);
		}
		else{
			Autor a=null;
			for(Autor tmp:autor) if(tmp.nombre.equals(request.getParameter("autor"))) a=tmp;
			a.libros.add(lib);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
