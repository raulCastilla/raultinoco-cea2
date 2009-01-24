package es.cea.tienda;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import java.util.List;

public class AplicacionListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContext) {
        System.out.println("Aplicacion iniciada....");
        List<Producto> catalogo=new ArrayList<Producto>();
        servletContext.getServletContext().setAttribute("catalogo", catalogo);
    }

    public void contextDestroyed(ServletContextEvent servletContext) {
        System.out.println("Aplicacion finalizada...");// TODO Auto-generated method stub
    }
	
}
