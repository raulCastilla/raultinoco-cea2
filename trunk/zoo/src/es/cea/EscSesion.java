package es.cea;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class EscSesion implements HttpSessionListener {

	
    public void sessionCreated(HttpSessionEvent arg0) {
    	List<Jirafa> colectJ=new ArrayList<Jirafa>();
    	arg0.getSession().setAttribute("jirafas", colectJ);
    	List<Leon> colectL=new ArrayList<Leon>();
    	arg0.getSession().setAttribute("leones", colectL);
    	List<Pantera> colectP=new ArrayList<Pantera>();
    	arg0.getSession().setAttribute("panteras", colectP);
    	System.out.println("Sesion iniciada");
        
    }
	
    public void sessionDestroyed(HttpSessionEvent arg0) {
        List<Jirafa> ji=(List<Jirafa>)arg0.getSession().getServletContext().getAttribute("jirafas");
        ji.addAll((List<Jirafa>)arg0.getSession().getAttribute("jirafas"));
        List<Leon> le=(List<Leon>)arg0.getSession().getServletContext().getAttribute("leones");
        le.addAll((List<Leon>)arg0.getSession().getAttribute("leones"));
        List<Pantera> pa=(List<Pantera>)arg0.getSession().getServletContext().getAttribute("panteras");
        pa.addAll((List<Pantera>)arg0.getSession().getAttribute("panteras"));
        System.out.println("Sesion destruida");
    }
	
}
