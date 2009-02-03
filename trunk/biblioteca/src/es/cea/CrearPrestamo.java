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
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuUser);
		pw.println("<h3 style='color: #FF0000'>HACER PRÉSTAMO</h3>");
		
		List<Prestamo> prestamos = (List<Prestamo>)request.getSession().getServletContext().getAttribute(AtributosConstantes.prestamos.toString());
		Prestamo[] prestamoUsuario = (Prestamo[])request.getSession().getAttribute(AtributosConstantes.prestamosUsuario.toString());
		List<Libro> libro = (List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		Integer numPrestamo = (Integer)request.getSession().getAttribute(AtributosConstantes.numeroPrestamos.toString());
		Libro lib=null;
		
		for(Libro tmp:libro) if(tmp.referencia.equals(request.getParameter("referencia"))) lib=tmp;
		Usuario user=(Usuario)request.getSession().getAttribute(AtributosConstantes.usuarioRegistrado.toString());
		
		if(user.permitido){
			if(!lib.prestado){
				if(user.numPrestamo.equals(3)){
					pw.println("YA NO PUEDE REALIZAR MÁS PRÉSTAMOS<br>");
				}
		
				if(user.numPrestamo<3){
					Prestamo pres = new Prestamo(lib,user);
					lib.prestado=true;
					prestamos.add(pres);
					user.prestamos[user.numPrestamo]=pres;
					user.numPrestamo++;
					
					
					//prestamoUsuario[numPrestamo]=pres;
					//numPrestamo++;
					//request.getSession().setAttribute(AtributosConstantes.numeroPrestamos.toString(), numPrestamo);
					pw.println("PR&Eacute;STAMO REALIZADO<br>");
					
				}
			}
			else{
				pw.println("ESE LIBRO YA ESTA PRESTADO");
			}
		}
		else{
			pw.println("NO SE LE PERMITE REALIZAR PRESTAMOS");
		}
		pw.println("<table border='1'>");
		pw.println("<tr><td><b>TITULO</b></td><td><b>FECHA DE PRESTAMO</b></td><td><b>FECHA DE DEVOLUCION</b></td></tr>");
		for(Prestamo p:user.prestamos){
			if(p!=null){
				pw.println("<tr><td>"+p.libro.titulo+"</td><td>"+p.fechaInicio.get(Calendar.DATE)+"/"+(p.fechaInicio.get(Calendar.MONTH)+1)+"/"+p.fechaInicio.get(Calendar.YEAR)+"</td><td>"+p.fechaFin.get(Calendar.DATE)+"/"+(p.fechaFin.get(Calendar.MONTH)+1)+"/"+p.fechaFin.get(Calendar.YEAR)+"</td></tr>");
			}
		}
		pw.println("</table>");
		pw.println(HtmlUtilities.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
