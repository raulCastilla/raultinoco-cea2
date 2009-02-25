package es.cea.listeners;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import es.cea.dao.implement.DaoUsuario;
import es.cea.dao.implement.DaoUsuarioMySQL;
import es.cea.excepcion.BibliotecaDaoExcepcion;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
public class RequestListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestListener() {

    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0) {

    	HttpServletRequest httpservletRequest = (HttpServletRequest) arg0.getServletRequest();
    	DaoUsuarioMySQL daoUsuario=(DaoUsuarioMySQL) httpservletRequest.getSession().getAttribute("daoUsuario");
    	try {
			daoUsuario.desconecta();
		} catch (BibliotecaDaoExcepcion e) {

			e.printStackTrace();
		}
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0) {
    	HttpServletRequest httpservletRequest = (HttpServletRequest) arg0.getServletRequest();
    	DaoUsuarioMySQL daoUsuario=(DaoUsuarioMySQL) httpservletRequest.getSession().getAttribute("daoUsuario");
    	try {
			daoUsuario.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		} catch (BibliotecaDaoExcepcion e) {

			e.printStackTrace();
		}
    }
	
}
