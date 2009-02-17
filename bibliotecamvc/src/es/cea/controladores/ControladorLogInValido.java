package es.cea.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.Dao;
import es.cea.dao.implement.DaoUsuario;
import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.LoginException;
import es.cea.recursos.AtributosConstantes;

public class ControladorLogInValido extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoUsuario dao = (DaoUsuario)request.getSession().getServletContext().getAttribute(AtributosConstantes.daoUsuario.toString());
		List<Usuario> usuario = dao.getLista();

		try{
			if(request.getParameter("correo")!=null && request.getParameter("clave")!=null){
					Usuario usu = new Usuario("nombre", request.getParameter("coreo"),request.getParameter("clave")); 
						if(usuario.contains(usu)){
							usu=usuario.get(usuario.indexOf(usu));
								if(usu.getRegistrado()){
									request.getSession().setAttribute(AtributosConstantes.usuarioRegistrado.toString(), usu);
									 String peti=(String)request.getSession().getAttribute(AtributosConstantes.peticionActual.toString());
									 //usuario administrador
									 if(request.getParameter("correo")=="admin" && request.getParameter("clave")=="admin")
									 //if(usu.getCorreo().equals(""))
									 {
										 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/");//????? 
					                	 requestDispatcher.forward(request, response); 
									 }
									 else
									    if(peti!=null){ 
					                          request.getRequestDispatcher(peti).forward(request, response);
					                    }
					                    else 
					                    {
					                    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ControladorPrestamo.java");//duda extension
					                		requestDispatcher.forward(request, response);
					                    }
					           else throw new LoginException("ERROR, aún no está usted admitido");//excepcion no admitido
						}      
					   else throw new LoginException("ERROR, compruebe que está registrado y que ha introducido los datos correctamente"); //excepcion no existe, equivocación 	   
				}   
				else
				{
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ControladorLogIn");//duda extension
            		requestDispatcher.forward(request, response);
				}
		}		
		catch(LoginException l){
		//System.out.println("ERROR");
	}
	
		
	
	
	
		}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
}
	
	

}
