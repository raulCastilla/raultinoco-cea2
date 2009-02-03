package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarAutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Autor> autor=(List<Autor>)request.getSession().getServletContext().getAttribute(AtributosConstantes.autores.toString());
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuAdmin);
		pw.println("<h3 style='color: #FF0000'>GESTIONAR AUTORES</h3>");
		
		if(request.getParameter("edit")!=null){
			Autor aut=null;
			for(Autor at:autor){
				if(at.nombre.equals(request.getParameter("autor"))){
					aut=at;
					aut.nombre=request.getParameter("nombre");
					System.out.println("Se ha modificado");
					//request.getRequestDispatcher("/editarautor").forward(request, response);
					response.sendRedirect("/biblioteca/admin/editarautor");
					
				}
				else{
					System.out.println("No se ha editado");
				}
			}
		}
		else if(request.getParameter("eliminar")!=null){
			for(int i=0;i<autor.size();i++){
				if(autor.get(i).nombre.equals(request.getParameter("name"))){
					String consoleOut=autor.get(i).nombre;
					autor.remove(i);
					System.out.println("Se ha eliminado el autor: "+consoleOut);
					//request.getRequestDispatcher("/editarautor").forward(request, response);
					response.sendRedirect("/biblioteca/admin/editarautor");
				}
			}
		}
		else if(request.getParameter("nombre")!=null){
			Autor aut=null;
			for(Autor a:autor){
				if(a.nombre.equals(request.getParameter("nombre"))) aut=a;
			}
			pw.println("<form action='./editarautor?edit=true&autor="+aut.nombre+"' method='post'>"+
					"<table>"+
					"<tr><td>NOMBRE:</td><td><input type='text' name='nombre' value='"+aut.nombre+"'></td></tr>"+
					"<tr><td><input type='submit' value='Editar'></td><td></td></tr>"+
					"</table></form>");
		}
		else{
		pw.println("<a href='./crearautor'>Crear Autor</a>");
		pw.println("<table border='1'>");
		pw.println("<tr><td>NOMBRE</td><td>ACCION</td></tr>");
		for(Autor a:autor){
		pw.println("<tr><td>"+a.nombre+"</td><td><a href='./editarautor?nombre="+a.nombre+
						"'>Editar</a>/<a href='./editarautor?name="+a.nombre+"&eliminar=true'>Eliminar</a></td></tr>");
		}
		pw.println("</table>");
		pw.println("<a href='./crearautor'>Crear Autor</a>");
		}
		pw.println(HtmlUtilities.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
