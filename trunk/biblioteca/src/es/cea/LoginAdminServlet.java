package es.cea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuUser);
		pw.println("<h3 style='color: #FF0000'>LOGIN ADMINISTRADOR</h3>");
		if(request.getParameter("nombre")!=null&&request.getParameter("clave")!=null){
			if(Administrador.clave.equals(request.getParameter("clave"))&&Administrador.nombre.equals(request.getParameter("nombre"))){
				request.getSession().getServletContext().setAttribute(AtributosConstantes.administrador.toString(), true);
				//request.getRequestDispatcher("/admin/editarlibro").forward(request, response);
				response.sendRedirect("/biblioteca/admin/editarlibro");
			}
			else{
				pw.println("EL USUARIO O LA CONTRASE„A NO SON CORRECTOS");
			}
		}
		else{
			pw.println("<form action='./loginadmin' method='post'>" +
	        		"<table>"+
	                "<tr><td>Nombre:</td><td><input type='text' name='nombre' /></td></tr>" +
	                "<tr><td>Clave:</td><td><input type='password' name='clave' /></td></tr>" +
	                "<tr><td><input type='submit' value='Log In'/></td><td></td></tr></table></form>");
		}
		pw.println(HtmlUtilities.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
