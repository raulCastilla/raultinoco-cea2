package es.cea.filtros;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import es.cea.dao.implement.DaoUsuario;
import es.cea.dao.modelo.Usuario;
import es.cea.recursos.AtributosConstantes;


public class PrestamoFiltro implements Filter {
    public PrestamoFiltro() {
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request.getParameter("referencia")!=null){
			
		}
		
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
