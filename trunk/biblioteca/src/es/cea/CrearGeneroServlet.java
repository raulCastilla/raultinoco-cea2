package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrearGeneroServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Genero> genero=(List<Genero>)request.getSession().getServletContext().getAttribute(AtributosConstantes.generos.toString());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuAdmin);
		pw.println("<h3 style='color: #FF0000'>AGREGAR NUEVO GENERO</h3>");
		
		if(request.getParameter("crear")!=null){
			Genero gen = new Genero(request.getParameter("genero"));
			if(!genero.contains(gen)){ 
				genero.add(gen);
				response.sendRedirect("/biblioteca/admin/editargenero");
			}
			else{
				pw.println("El genero ya existe.");	
			}				
		}
		else {
			pw.println("<form action='./creargenero?crear=true' method='post'>"+
					"<table>"+
					"<tr><td>GENERO:</td><td><input type='text' name='genero' /></td></tr>"+
					"<tr><td><input type='submit' value='Crear' /></td><td></td></tr>"+
					"</table></form>");	
		}
		pw.println(HtmlUtilities.fin);
		pw.close();	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
			doGet(request, response);
	}

}
