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
        /*autores.add(new Autor("Julio Verne"));
        autores.add(new Autor("H.G.Wells"));
        autores.add(new Autor("Miguel de Cervantes"));
        autores.add(new Autor("Charles Dickens"));
        autores.add(new Autor("Friedrich Nietzsche"));
        autores.add(new Autor("Homero"));
        autores.add(new Autor("Lewis Carroll"));
        autores.add(new Autor("Agatha Christie"));
        autores.add(new Autor("Edgar Allan Poe"));
        autores.add(new Autor("William Shakespeare"));*/
        contextEvent.getServletContext().setAttribute(AtributosConstantes.autores.toString(), autores);
        List<Prestamo> prestamos = new ArrayList<Prestamo>();
        contextEvent.getServletContext().setAttribute(AtributosConstantes.prestamos.toString(), prestamos);
        List<Libro> libros = new ArrayList<Libro>();
     
        libros.add(new Libro("Ref001","La Vuelta al Mundo en 80 Dias",new Genero("Aventuras"),new Autor("Julio Verne"),12,4,1873));
        libros.add(new Libro("Ref002","La Guerra de los Mundos",new Genero("Ciencia-Ficcion"),new Autor("H.G.Wells"),13,10,1898));
        libros.add(new Libro("Ref003","Don Quijote de La Mancha",new Genero("Clasicos"),new Autor("Miguel de Cervantes"),14,5,1605));
        libros.add(new Libro("Ref004","Cuento de Navidad",new Genero("Cuentos y Leyendas"),new Autor("Charles Dickens"),11,12,1843));
        libros.add(new Libro("Ref005","Asi Hablo Zaratrustra",new Genero("Ensayos"),new Autor("Friedrich Nietzsche"),12,9,1883));
        libros.add(new Libro("Ref006","La Iliada",new Genero("Griega y Romana"),new Autor("Homero"),1,1,1));
        libros.add(new Libro("Ref007","Alicia en el Pais de las Maravillas",new Genero("Infantil y Juvenil"),new Autor("Lewis Carroll"),14,3,1864));
        libros.add(new Libro("Ref008","Cita con la Muerte",new Genero("Novela Policial"),new Autor("Agatha Christie"),21,8,1938));
        libros.add(new Libro("Ref009","El Cuervo",new Genero("Terror"),new Autor("Edgar Allan Poe"),23,1,1845));
        libros.add(new Libro("Ref010","El Rey Lear",new Genero("Teatro"),new Autor("William Shakespeare"),17,7,1608));
         
        contextEvent.getServletContext().setAttribute(AtributosConstantes.libros.toString(), libros);
        List<Solicitud> solicitudes = new ArrayList<Solicitud>();
        contextEvent.getServletContext().setAttribute(AtributosConstantes.solicitudes.toString(), solicitudes);
        List<Genero> generos = new ArrayList<Genero>();
        /*generos.add(new Genero("Aventuras"));
        generos.add(new Genero("Ciencia-Ficcion"));
        generos.add(new Genero("Clasicos"));
        generos.add(new Genero("Cuentos y Leyendas"));
        generos.add(new Genero("Ensayos"));
        generos.add(new Genero("Griega y Romana"));
        generos.add(new Genero("Infantil y Juvenil"));
        generos.add(new Genero("Novela Policial"));
        generos.add(new Genero("Terror"));
        generos.add(new Genero("Teatro"));*/
        contextEvent.getServletContext().setAttribute(AtributosConstantes.generos.toString(), generos);
        
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {
        System.out.println("Finalizando aplicacion....");
    }
	
}
