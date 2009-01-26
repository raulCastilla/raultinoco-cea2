package es.cea.tienda;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AplicacionListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent contextEvent) {
       List<Producto> catalogo=new ArrayList<Producto>();
       catalogo.add(new Producto(1,34.5,"Pelota"));
       catalogo.add(new Producto(2,60.5,"Raqueta"));
       catalogo.add(new Producto(3,23.12,"Zapatillas"));
       catalogo.add(new Producto(4,80.9,"Gafas"));
       contextEvent.getServletContext().setAttribute(AtributosConstantes.catalogo.toString(), catalogo);
    }

    public void contextDestroyed(ServletContextEvent contextEvent) {
        System.out.println("Saliendo de la aplcacion....");
    }
	
}
