package es.cea;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;


public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter pw = response.getWriter();
	HtmlUtilities html=new HtmlUtilities("Detalles");
	pw.println(html.head);
    pw.println(html.cuerpo);
    
    List<Libro> libros=(List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());

    Libro l=null;
    for(Libro lib:libros){
    	if( lib.referencia.equals(request.getParameter("ref"))) {
    		l=lib;
    	}
    }
    
    pw.println("<h4>Detalle del libro: " + l.titulo + "</h4>");
    pw.println("Referencia: "+ l.referencia+"<br>");
    pw.println("Autor: " + l.autor + "<br>");
    pw.println("Género: " + l.genero + "br>");
    pw.println("Fecha de publicación: " + l.fechaPublicacion + "<br>");
    pw.println("Prestado: " + l.prestado + "<br>");
    

    if(l.prestado == false){
    	pw.println("<a href='./prestamo?referencia="+l.referencia+"'>Realizar pr&eacute;stamo</a><br>");
    }
    else pw.println("<a href='./biblioteca'>Ir a la página principal</a>");
    	
    pw.println(html.fin);
    pw.close();
    
   
    
	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
