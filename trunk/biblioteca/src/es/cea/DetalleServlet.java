package es.cea;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;


public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	List<Libro> libros=(List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
	
	response.setContentType("text/html");
	PrintWriter pw = response.getWriter();
	pw.println(HtmlUtilities.head);
    pw.println(HtmlUtilities.cuerpo);
	pw.println(HtmlUtilities.menuUser);
	pw.println("<h3 style='color: #FF0000'>DETALLES</h3>");
    

    Libro l=null;
    for(Libro lib:libros){
    	if( lib.referencia.equals(request.getParameter("ref"))) {
    		l=lib;
    	}
    }
    String prest = (l.prestado)?"SI":"NO";
    pw.println("<h4>Detalle del libro: " + l.titulo + "</h4>");
    pw.println("Referencia: "+ l.referencia+"<br>");
    pw.println("Autor: " + l.autor + "<br>");
    pw.println("Género: " + l.genero + "<br>");
    pw.println("Fecha de publicación: " + l.fechaPublicacion.get(Calendar.DATE)+"/"+(l.fechaPublicacion.get(Calendar.MONTH)+1)+"/"+l.fechaPublicacion.get(Calendar.YEAR) + "<br>");
    pw.println("Prestado: " + prest + "<br>");
    

    if(l.prestado == false){
    	pw.println("<a href='./prestamo?referencia="+l.referencia+"'>Realizar pr&eacute;stamo</a><br>");
    }
    
    	
    pw.println(HtmlUtilities.fin);
    pw.close();
    
   
    
	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
