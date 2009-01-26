package es.cea.tienda;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UsuarioTiendaListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent arg0) {
    	List<Producto> carrito=new ArrayList<Producto>();
        arg0.getSession().setAttribute(AtributosConstantes.carrito.toString(), carrito);
        System.out.println("Iniciando sesion....");
    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
        //arg0.getSession().removeAttribute("carrito");
    	System.out.println("Saliendo de la sesion....");
    }
	
}
