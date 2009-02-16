package es.cea.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import es.cea.dao.modelo.Autor;
import es.cea.dao.modelo.Genero;
import es.cea.dao.modelo.Libro;
import es.cea.dao.Dao;
import es.cea.dao.implement.DaoAutor;
import es.cea.dao.implement.DaoGenero;
import es.cea.dao.implement.DaoLibro;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.FechaNoValidaException;
import es.cea.servicios.ServicioCalendario;

public class AplicacionListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("Aplicacion iniciada...");
        
        Dao dao = new DaoGenero();
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
        	dao.agregar(gen1);
        	dao.agregar(gen2);
        	dao.agregar(gen3);
        	dao.agregar(gen4);
        	dao.agregar(gen5);
        	dao.agregar(gen6);
        	dao.agregar(gen7);
        	dao.agregar(gen8);
        	dao.agregar(gen9);
        	dao.agregar(gen10);
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
        
        dao = new DaoAutor();
        
        try{
        	dao.agregar(aut1);
        	dao.agregar(aut2);
        	dao.agregar(aut3);
        	dao.agregar(aut4);
        	dao.agregar(aut5);
        	dao.agregar(aut6);
        	dao.agregar(aut7);
        	dao.agregar(aut8);
        	dao.agregar(aut9);
        	dao.agregar(aut10);
        }
        catch(BibliotecaDaoExcepcion e){
        	System.out.println("Error al agregar autores");
        }
        
        
        dao = new DaoLibro();
        
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
			
			dao.agregar(lib1);
			dao.agregar(lib2);
			dao.agregar(lib3);
			dao.agregar(lib4);
			dao.agregar(lib5);
			dao.agregar(lib6);
			dao.agregar(lib7);
			dao.agregar(lib8);
			dao.agregar(lib9);
			dao.agregar(lib10);
		} 
        catch (FechaNoValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("Error al introducir libros");
		}
		
		
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    	System.out.println("Aplicacion finalizada...");
    }
	
}
