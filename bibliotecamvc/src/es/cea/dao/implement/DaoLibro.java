package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Libro;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoLibro extends DaoAbstract<Libro>{

	@Override
	public Libro obtener(Object o) throws BibliotecaDaoExcepcion {
		List<Libro> libros = getLista();
		
		String referencia=(String) o;

		List<Libro> libros=dao.getLista();
		for(Libro l:libros){
			//if(libros.contains(request.getParameter("")){
			//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/usuario/detalle.jsp?referencia="+ l.getReferencia());
			//requestDispatcher.forward(request, response);
		//}
		//else
			//excepcion
		//end if;
			
		}

		
		
		return super.obtener(o);
	}

	@Override
	public List<Libro> getLista() {
		return BibliotecaDB.getInstance().getLibros();
	}
	
}
