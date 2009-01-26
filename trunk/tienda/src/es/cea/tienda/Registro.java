package es.cea.tienda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HtmlUtilities html=new HtmlUtilities("Registro");
		pw.println(html.head);
		pw.println(html.cuerpo);
		if(request.getParameter("nombre")!=null){
			//esto no lo entiendo
			request.getSession().setAttribute(AtributosConstantes.usuario.toString(),request.getParameter("nombre") );
			String peticionActual=(String)request.getSession().getAttribute(AtributosConstantes.peticionActual.toString());
			if(peticionActual!=null) request.getRequestDispatcher(peticionActual).forward(request, response);
		}
		if(request.getSession().getAttribute(AtributosConstantes.usuario.toString())==null){
			pw.println("<form action='./registro' method='post'>");
			pw.println("Nombre: <input type='text' name='nombre'>");
			pw.println("Clave: <input type='password' name='clave'>");
			pw.println("<input type='submit' value='Enviar'>");
			pw.println("</form>");
			
		}
		/*else{
			pw.println("YA ESTAS REGISTRADO: "+request.getSession().getAttribute(AtributosConstantes.usuario.toString())+"<br>");
			pw.println("<a href='./catalogo'>I al catalogo</a>");
		}*/
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
