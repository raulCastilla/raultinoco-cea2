package es.cea;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class AplicacionListener
 *
 */
public class AplicacionListener implements ServletContextListener {

  
    public void contextInitialized(ServletContextEvent arg0) {
    
    	System.out.println("aplicacion inicializada");
    	Bean bean=new Bean();
    	bean.valor1.add("uno lista");
    	bean.valor1.add("dos lista");
    	bean.valor1.add("tres lista");
    	
    	bean.valor2.put("uno", "uno mapa");
    	bean.valor2.put("dos", "dos mapa");
    	bean.valor2.put("tres", "tres mapa");
    	
    	arg0.getServletContext().setAttribute("bean", bean);

    }


    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
