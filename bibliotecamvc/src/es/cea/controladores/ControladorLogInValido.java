package es.cea.controladores;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;

import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;
import es.cea.excepcion.LoginException;
import es.cea.recursos.AtributosConstantes;

public class ControladorLogInValido extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Usuario> dao = (Dao<Usuario>)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoUsuario.toString());
		
		try {
			String correoRequest = request.getParameter("correo");
			if(correoRequest!=null){
		    Usuario usuarioActual = dao.obtener(correoRequest);
		    
		    if(usuarioActual==null){
		    	//el usuario no se en encuentra
		    	request.setAttribute("error", new LoginException("No existe el usuario con el correo: "+correoRequest));
		    	request.getRequestDispatcher("usuario/solicitarregistro.jsp").forward(request, response);
		    }else if(usuarioActual.getCorreo().equals("admin") && usuarioActual.getClve().equals("admin")){
		    	//el usuario es administrador
		    	request.getSession().setAttribute("usuario", usuarioActual);
		    	request.getRequestDispatcher("/controladorcatalogoadministrador").forward(request, response);
		    }else{
		    	//usaurio es registrado
		    	request.getSession().setAttribute("usuario", usuarioActual);
		    	request.getRequestDispatcher("controladorcatalogo").forward(request, response);
		     }
		    
			}else{
				//correo es nulo
			 	request.setAttribute("error", new LoginException("el correo es nulo!"));
			 	request.getRequestDispatcher("usuario/error.jsp").forward(request, response);
			}

		} catch (BibliotecaDaoExcepcion e) {
			e.printStackTrace();
		}
	
		
	
	
	
		}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
}
	
	

}
