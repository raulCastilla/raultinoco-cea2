package es.cea;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrearPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Prestamo> prestamos = (List<Prestamo>)request.getSession().getServletContext().getAttribute(AtributosConstantes.prestamos.toString());
		List<Prestamo> prestamoUsuario = (List<Prestamo>)request.getSession().getAttribute(AtributosConstantes.prestamosUsuario.toString());
		List<Libro> libro = (List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		
		Libro lib=null;
		for(Libro tmp:libro) if(tmp.referencia.equals(request.getParameter("referencia"))) lib=tmp;
		Usuario user=(Usuario)request.getSession().getAttribute(AtributosConstantes.usuarioRegistrado.toString());
		Prestamo pres = new Prestamo(lib,user);
		prestamos.add(pres);
		prestamoUsuario.add(pres);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
