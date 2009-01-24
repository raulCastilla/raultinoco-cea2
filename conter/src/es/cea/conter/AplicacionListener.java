package es.cea.conter;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AplicacionListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Saliendo de la aplicacion");
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		arg0.getServletContext().setAttribute("contador", new Contador());
		arg0.getServletContext().setAttribute("chat", new ArrayList<String>());
		System.out.println("Aplicion iniciada");
		
	}

}
