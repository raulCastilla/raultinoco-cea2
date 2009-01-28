package es.cea;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class EscContexto implements ServletContextListener {

    public void contextInitialized(ServletContextEvent arg0) {
       
       List<Jirafa> todosJ=new ArrayList<Jirafa>();
       arg0.getServletContext().setAttribute("jirafas", todosJ);
       List<Leon> todosL=new ArrayList<Leon>();
       arg0.getServletContext().setAttribute("leones", todosL);
       List<Pantera> todosP=new ArrayList<Pantera>();
       arg0.getServletContext().setAttribute("panteras", todosP);
    }

	
    public void contextDestroyed(ServletContextEvent arg0) {
       System.out.println("Saliendo de la aplicacion");
    }
	
}
