package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrearAutorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Autor> autor=(List<Autor>)request.getSession().getServletContext().getAttribute(AtributosConstantes.autores.toString());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuAdmin);
		pw.println("<h3 style='color: #FF0000'>AGREGAR NUEVO AUTOR</h3>");
		
		if(request.getParameter("crear")!=null){
			Autor aut = new Autor(request.getParameter("autor"));
			
			
			
			if(!autor.contains(aut)){ 
				autor.add(aut);
				response.sendRedirect("/biblioteca/admin/editarautor");
			}
			else{
				pw.println("El autor ya existe.");	
			}	
			
		}
		else {
			pw.println("<form action='./crearautor?crear=true' method='post'>"+
					"<table>"+
					"<tr><td>AUTOR:</td><td><input type='text' name='autor' /></td></tr>"+
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
