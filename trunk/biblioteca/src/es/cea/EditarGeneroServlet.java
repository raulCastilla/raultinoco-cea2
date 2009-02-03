package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarGeneroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Genero> genero=(List<Genero>)request.getSession().getServletContext().getAttribute(AtributosConstantes.generos.toString());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuAdmin);
		pw.println("<h3 style='color: #FF0000'>GESTIONAR GÉNEROS</h3>");
		
		
		if(request.getParameter("editar")!=null){
			Genero gen=null;
			
			for(Genero g:genero){
				if(g.nombre.equals(request.getParameter("gen"))) gen=g;
			}
			gen.nombre=request.getParameter("genero");
			response.sendRedirect("/biblioteca/admin/editargenero");
			//request.getRequestDispatcher("/editargenero").forward(request, response);
			//pw.println("GENERO MODIFICADO");
			
		}
		else if(request.getParameter("eliminar")!=null){
			for(int i=0;i<genero.size();i++){
				if(genero.get(i).nombre.equals(request.getParameter("name"))){
					genero.remove(i);
					response.sendRedirect("/biblioteca/admin/editargenero");
				}
			}
		}
		else if(request.getParameter("nombre")!=null){
			Genero gen=null;
			for(Genero g:genero){
				if(g.nombre.equals(request.getParameter("nombre"))) gen=g;
			}
			pw.println("<form action='./editargenero?editar=true&gen="+gen.nombre+"' method='post'>"+
					"<table>"+
					"<tr><td>NOMBRE:</td><td><input type='text' name='genero' value='"+gen.nombre+"' /></td></tr>"+
					"<tr><td><input type='submit' value='Editar' /></td><td></td></tr>"+
					"</table></form>");
		}
		else{
		pw.println("<a href='./creargenero'>Crear genero</a>");
		pw.println("<table border='1'>");
		pw.println("<tr><td>NOMBRE</td><td>ACCION</td></tr>");
		for(Genero g:genero){
			if(g!=null){
			pw.println("<tr><td>"+g.nombre+"</td><td><a href='./editargenero?nombre="+g.nombre+
						"'>Editar</a>/<a href='./editargenero?eliminar=true&name="+g.nombre+"'>Eliminar</a></td></tr>");
			}
		}
		pw.println("</table>");
		pw.println("<a href='./creargenero'>Crear genero</a>");
		}
		pw.println(HtmlUtilities.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
