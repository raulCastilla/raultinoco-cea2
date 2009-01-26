package es.cea.tienda;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FiltroSeguridad implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest=(HttpServletRequest)request;
		Object nombreUsuario = servletRequest.getSession().getAttribute(AtributosConstantes.usuario.toString());
		if(nombreUsuario==null){
			//Repartidor de solicictudes
			RequestDispatcher dispatcher=request.getRequestDispatcher("/registro");
			dispatcher.forward(request, response);
			
		}
		else{
			//Permite continuar la peticion al servlet
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
