package es.cea.listeners;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Genero;
import es.cea.dao.modelo.Libro;
import es.cea.dao.modelo.Prestamo;
import es.cea.dao.modelo.Solicitud;
import es.cea.dao.modelo.Usuario;
import es.cea.dao.modelo.UsuarioNoRegistrado;
import es.cea.dao.modelo.UsuarioRegistrado;
import es.cea.dao.Dao;
import es.cea.dao.implement.DaoAutor;
import es.cea.dao.implement.DaoGenero;
import es.cea.dao.implement.DaoLibro;
import es.cea.dao.implement.DaoPrestamo;
import es.cea.dao.implement.DaoSolicitud;
import es.cea.dao.implement.DaoUsuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.FechaNoValidaException;
import es.cea.recursos.AtributosConstantes;
import es.cea.servicios.ServicioCalendario;

public class AplicacionListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("Aplicacion iniciada...");
        
        Dao daoAutor = new DaoAutor();
        Dao daoGenero = new DaoGenero();
        Dao daoLibro = new DaoLibro();
        Dao daoPrestamo = new DaoPrestamo();
        Dao daoSolicitud = new DaoSolicitud();
        Dao daoUsuario = new DaoUsuario();
        
        
        ServicioCalendario serv = new ServicioCalendario();
        
        Genero gen1=new Genero("Aventuras");
        Genero gen2=new Genero("Ciencia-Ficcion");
        Genero gen3=new Genero("Clasicos");
        Genero gen4=new Genero("Cuentos y Leyendas");
        Genero gen5=new Genero("Ensayos");
        Genero gen6=new Genero("Griega y Romana");
        Genero gen7=new Genero("Infantil y Juvenil");
        Genero gen8=new Genero("Novela Policial");
        Genero gen9=new Genero("Terror");
        Genero gen10=new Genero("Teatro");
        
        try{
        	daoGenero.agregar(gen1);
        	daoGenero.agregar(gen2);
        	daoGenero.agregar(gen3);
        	daoGenero.agregar(gen4);
        	daoGenero.agregar(gen5);
        	daoGenero.agregar(gen6);
        	daoGenero.agregar(gen7);
        	daoGenero.agregar(gen8);
        	daoGenero.agregar(gen9);
        	daoGenero.agregar(gen10);
        }
        catch (BibliotecaDaoExcepcion e) {
			System.out.println("Se han producido errores al agregar los generos");
		}
        
        Autor aut1 = new Autor("Julio Verne");
        Autor aut2 = new Autor("H.G. Wells");
        Autor aut3 = new Autor("Miguel de Cervantes");
        Autor aut4 = new Autor("Charles Dickens");
        Autor aut5 = new Autor("Friederich Nietzche");
        Autor aut6 = new Autor("Homero");
        Autor aut7 = new Autor("Lewis Carrol");
        Autor aut8 = new Autor("Agatha Christie");
        Autor aut9 = new Autor("Edgar Allan Poe");
        Autor aut10 = new Autor("William Shakespeare");
        
        
        try{
        	daoAutor.agregar(aut1);
        	daoAutor.agregar(aut2);
        	daoAutor.agregar(aut3);
        	daoAutor.agregar(aut4);
        	daoAutor.agregar(aut5);
        	daoAutor.agregar(aut6);
        	daoAutor.agregar(aut7);
        	daoAutor.agregar(aut8);
        	daoAutor.agregar(aut9);
        	daoAutor.agregar(aut10);
        }
        catch(BibliotecaDaoExcepcion e){
        	System.out.println("Error al agregar autores");
        }
        
        
       
        
        try {
			Libro lib1 = new Libro("La Vuelta al Mundo en 80 Dias","Ref001",serv.stringToCalendario("12/04/1873"),aut1,gen1);
			Libro lib2 = new Libro("La Guerra de los Mundos","Ref002",serv.stringToCalendario("13/10/1898"),aut2,gen2);
			Libro lib3 = new Libro("Don Quijote de la Mancha","Ref003",serv.stringToCalendario("14/05/1605"),aut3,gen3);
			Libro lib4 = new Libro("Cuento de Navidad","Ref004",serv.stringToCalendario("11/12/1843"),aut4,gen4);
			Libro lib5 = new Libro("As’ Habl— Zaratrusta","Ref005",serv.stringToCalendario("12/09/1883"),aut5,gen5);
			Libro lib6 = new Libro("La Il’ada","Ref006",serv.stringToCalendario("01/01/0001"),aut6,gen6);
			Libro lib7 = new Libro("Alicia en el Pa’s de las Maravillas","Ref007",serv.stringToCalendario("14/03/1864"),aut7,gen7);
			Libro lib8 = new Libro("Cita con la Muerte","Ref008",serv.stringToCalendario("21/08/1938"),aut8,gen8);
			Libro lib9 = new Libro("El Cuervo","Ref009",serv.stringToCalendario("23/01/1845"),aut9,gen9);
			Libro lib10 = new Libro("El Rey Lear","Ref0010",serv.stringToCalendario("17/07/1608"),aut10,gen10);
			
			daoLibro.agregar(lib1);
			daoLibro.agregar(lib2);
			daoLibro.agregar(lib3);
			daoLibro.agregar(lib4);
			daoLibro.agregar(lib5);
			daoLibro.agregar(lib6);
			daoLibro.agregar(lib7);
			daoLibro.agregar(lib8);
			daoLibro.agregar(lib9);
			daoLibro.agregar(lib10);
		} 
        catch (FechaNoValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("Error al introducir libros");
		}
		//solicitudes
        try {
			Solicitud sol1 = new Solicitud(null, null, null);
						
			daoSolicitud.agregar(sol1);;
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("Error al introducir las solicitudes");
		}
        //prestamos
        try {
			Prestamo pres1 = new Prestamo (null, null, null, null);			
		
			daoPrestamo.agregar(pres1);;
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("Error al introducir los prestamos");
		}
		//usuarios
        try {
        	Usuario usu1= new UsuarioNoRegistrado ("aaa","a@gmail.com","a1a1");
			Usuario usu2=new UsuarioRegistrado ("bbb","b@BBB.com","B1B");	
			daoUsuario.agregar(usu1);;
			daoUsuario.agregar(usu2);;
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("Error al introducir los prestamos");
		}
		contextEvent.getServletContext().setAttribute(AtributosConstantes.daoAutor.toString(), daoAutor);
		contextEvent.getServletContext().setAttribute(AtributosConstantes.daoGenero.toString(), daoGenero);
		contextEvent.getServletContext().setAttribute(AtributosConstantes.daoLibro.toString(), daoLibro);
		contextEvent.getServletContext().setAttribute(AtributosConstantes.daoSolicitud.toString(), daoSolicitud);
		contextEvent.getServletContext().setAttribute(AtributosConstantes.daoPrestamo.toString(), daoPrestamo);
		contextEvent.getServletContext().setAttribute(AtributosConstantes.daoUsuario.toString(), daoUsuario);
		
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {
    	System.out.println("Aplicacion finalizada...");
    }
	
}
