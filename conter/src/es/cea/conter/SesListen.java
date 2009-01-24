package es.cea.conter;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

 
public class SesListen implements HttpSessionListener {
	//Integer activeSessions = 0;
    public void sessionDestroyed(HttpSessionEvent arg0) {
    	Contador c=(Contador)arg0.getSession().getServletContext().getAttribute("contador");
		if(c.usuario>0) c.usuario--;
        System.out.println("Sesion destruida");
    }

    public void sessionCreated(HttpSessionEvent arg0) {
        //activeSessions=activeSessions+1;
        
        Contador c=(Contador)arg0.getSession().getServletContext().getAttribute("contador");
		c.usuario++;
		//Hasta que no se crea una variable de sesion no se crea la sesion??
		System.out.println("Sesion creada");
    }
	
}
