package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrearPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HtmlUtilities html = new HtmlUtilities("Prestamos");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println(html.head);
		pw.println(html.cuerpo);
		
		List<Prestamo> prestamos = (List<Prestamo>)request.getSession().getServletContext().getAttribute(AtributosConstantes.prestamos.toString());
		Prestamo[] prestamoUsuario = (Prestamo[])request.getSession().getAttribute(AtributosConstantes.prestamosUsuario.toString());
		List<Libro> libro = (List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		Integer numPrestamo = (Integer)request.getSession().getAttribute(AtributosConstantes.numeroPrestamos.toString());
		Libro lib=null;
		
		for(Libro tmp:libro) if(tmp.referencia.equals(request.getParameter("referencia"))) lib=tmp;
		Usuario user=(Usuario)request.getSession().getAttribute(AtributosConstantes.usuarioRegistrado.toString());
		
		if(numPrestamo.equals(4)){
			pw.println("YA NO PUEDE REALIZAR M&Aacute;S PR&Eacute;STAMOS<br>");
		}
		
		if(numPrestamo<=3){
			Prestamo pres = new Prestamo(lib,user);
			prestamos.add(pres);
			numPrestamo++;
			prestamoUsuario[numPrestamo-1]=pres;
			request.getSession().setAttribute(AtributosConstantes.numeroPrestamos.toString(), numPrestamo);
			pw.println("PR&Eacute;STAMO REALIZADO<br>");
			pw.println("<a href='./biblioteca'>Lista de libros</a><br>");
		}
		pw.println("<table>");
		for(Prestamo p:prestamoUsuario){
			if(p!=null){
				pw.println("<tr><td>"+p.libro.titulo+"</td><td>"+p.fechaInicio.get(Calendar.DAY_OF_YEAR)+"</td><td>"+p.fechaFin.get(Calendar.DAY_OF_YEAR)+"</td></tr>");
			}
		}
		pw.println("</table>");
		pw.println(html.fin);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
