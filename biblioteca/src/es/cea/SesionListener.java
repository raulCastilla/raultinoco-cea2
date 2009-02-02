package es.cea;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SesionListener implements HttpSessionListener {

    public void sessionDestroyed(HttpSessionEvent sesionEvent) {
    	//sesionEvent.getSession().removeAttribute(AtributosConstantes.prestamosUsuario.toString());
    	//sesionEvent.getSession().removeAttribute(AtributosConstantes.numeroPrestamos.toString());
    	//sesionEvent.getSession().removeAttribute(AtributosConstantes.usuarioRegistrado.toString());
    	//sesionEvent.getSession().removeAttribute(AtributosConstantes.administrador.toString());
    	System.out.println("FINALIZANDO SESION....");
    }

    public void sessionCreated(HttpSessionEvent sesionEvent) {
       
        //Prestamo[] prestamos = new Prestamo[3];
        //Integer numPrestamos = 0;
    	//sesionEvent.getSession().setAttribute(AtributosConstantes.prestamosUsuario.toString(), prestamos);
    	//sesionEvent.getSession().setAttribute(AtributosConstantes.numeroPrestamos.toString(), numPrestamos);
    	System.out.println("INICIANDO SESION......");
    }
	
}
