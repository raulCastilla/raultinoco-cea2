package es.cea;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SesionListener implements HttpSessionListener {

    public void sessionDestroyed(HttpSessionEvent sesionEvent) {
    	System.out.println("FINALIZANDO SESION....");
    }

    public void sessionCreated(HttpSessionEvent sesionEvent) {
       System.out.println("INICIANDO SESION......");
    }
	
}
