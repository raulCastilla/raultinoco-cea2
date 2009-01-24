package es.cea.conter;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		Contador cont=(Contador)arg0.getServletContext().getAttribute("contador");
		cont.visitas++;
		
	}


}
