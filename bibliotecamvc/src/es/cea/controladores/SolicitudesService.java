package es.cea.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.cea.dao.Dao;
import es.cea.dao.modelo.Solicitud;
import es.cea.dao.modelo.Usuario;
import es.cea.dao.modelo.UsuarioRegistrado;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class SolicitudesService extends ForwardService{
	
	@Override
	public void add(HttpServletRequest request, HttpServletResponse response,
			Object ob, String uri, Dao dao) throws BibliotecaDaoExcepcion,
			IOException, ServletException {

		String mail = (String)ob;
		
		
		try{
			Solicitud sol = (Solicitud)dao.obtener(mail);
			
			Usuario us = sol.getUsuario();
			if(!us.isUsuarioRegistrado()){
				UsuarioRegistrado reg = new UsuarioRegistrado(us.getNombre(),us.getCorreo(),us.getClave());
				us = reg;
			}
			
			request.setAttribute("lista", dao.obtenerLista());
			forward(request, response, uri);
		}
			catch(BibliotecaDaoExcepcion e){
				System.out.println("El usuario ya existe");
				request.setAttribute("lista", dao.obtenerLista());
				request.setAttribute("error", getErrorExiste());
				forward(request, response, uri);
			}
	}	
	@Override
	public void delete(HttpServletRequest request,
			HttpServletResponse response, Dao dao, String uri,Object ob)
			throws BibliotecaDaoExcepcion, IOException, ServletException {
		// TODO Auto-generated method stub
		String mail = (String)ob;
		
		try{
			dao.eliminar(dao.obtener(mail));
			request.setAttribute("lista", dao.obtenerLista());
			forward(request, response, uri);
		}
		catch (BibliotecaDaoExcepcion e) {
			System.out.println("El usuario no existe");
			request.setAttribute("error", getErrorNoExiste());
			forward(request, response, uri);
		}
	}	
}
	


