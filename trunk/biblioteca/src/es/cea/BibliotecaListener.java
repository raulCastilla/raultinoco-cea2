package es.cea;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BibliotecaListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent contextEvent) {
        List<Usuario> usuarios = new ArrayList<Usuario>();
    	contextEvent.getServletContext().setAttribute(AtributosConstantes.usuarios.toString(), usuarios);
        List<Autor> autores = new ArrayList<Autor>();
        contextEvent.getServletContext().setAttribute(AtributosConstantes.autores.toString(), autores);
        List<Prestamo> prestamos = new ArrayList<Prestamo>();
        contextEvent.getServletContext().setAttribute(AtributosConstantes.prestamos.toString(), prestamos);
        List<Libro> libros = new ArrayList<Libro>();
     
        
        //libros.add(new Libro("Ref 1","Yo puta","Best Seller","Isabel Pisano",false,"Marzo 2001"));
         
        
        contextEvent.getServletContext().setAttribute(AtributosConstantes.libros.toString(), libros);
        List<Solicitud> solicitudes = new ArrayList<Solicitud>();
        contextEvent.getServletContext().setAttribute(AtributosConstantes.solicitudes.toString(), solicitudes);
        List<Genero> generos = new ArrayList<Genero>();
        contextEvent.getServletContext().setAttribute(AtributosConstantes.generos.toString(), generos);
        
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {
        System.out.println("Finalizando aplicacion....");
    }
	
}
