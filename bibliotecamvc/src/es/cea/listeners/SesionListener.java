package es.cea.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import es.cea.dao.implement.DaoUsuarioMySQL;

/**
 * Application Lifecycle Listener implementation class SesionListener
 *
 */
public class SesionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SesionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent eventoSession) {
    	eventoSession.getSession().setAttribute("daoUsuario", new DaoUsuarioMySQL());
    	
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
