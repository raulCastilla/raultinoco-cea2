package es.cea.filtros;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import es.cea.recursos.Utilidades;
import es.cea.dao.Dao;
import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.recursos.AtributosConstantes;


public class PrestamoFiltro implements Filter {
    public PrestamoFiltro() {
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try{
			if(request.getParameter("referencia")!=null){
				HttpServletRequest httpRequest=(HttpServletRequest)request;
				String peticionActualUsuario=Utilidades.obtenerURLActual(httpRequest);
				System.out.println("petition actual con parametros:"+peticionActualUsuario);
				Dao<Usuario> dao = (Dao<Usuario>)httpRequest.getSession().getServletContext().getAttribute(AtributosConstantes.daoUsuario.toString());	
				String usuarioRegistrado=request.getParameter("registrado");
				Usuario usuario= dao.obtener(usuarioRegistrado);
					if(usuario.getRegistrado().booleanValue()==false){
						httpRequest.getSession().setAttribute(AtributosConstantes.peticionActual.toString(), peticionActualUsuario);
						RequestDispatcher repartidorSolicitudes = request.getRequestDispatcher("/controladorlogin");
						repartidorSolicitudes.forward(request, response);
                    }
					else{
						chain.doFilter(request, response);
					}
			}
		}catch(BibliotecaDaoExcepcion e){
			e.printStackTrace();
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
