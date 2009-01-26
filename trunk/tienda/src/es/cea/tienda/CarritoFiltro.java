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

public class CarritoFiltro implements Filter {

    public CarritoFiltro() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request.getParameter("carrito")!=null){
			 System.out.println("INTENTANDO HACER ALGO AL CARRITO");
             HttpServletRequest httpRequest=(HttpServletRequest)request;
             String peticionActualUsuario=Utilidades.obtenerURLActual(httpRequest);
             System.out.println("petition actual con parametros:"+peticionActualUsuario);

             //comprobamos que el usuario esta registrado
             String usuario = (String)httpRequest.getSession().getAttribute(AtributosConstantes.usuario.toString());
             if(usuario==null){
                     //en caso negativo reenviamos la peticion a /registro
            	 httpRequest.getSession().setAttribute(AtributosConstantes.peticionActual.toString(), peticionActualUsuario);
            	 RequestDispatcher repartidorSolicitudes = request.getRequestDispatcher("/registro");
            	 repartidorSolicitudes.forward(request, response);
                     
             }

		}
		else chain.doFilter(request, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
