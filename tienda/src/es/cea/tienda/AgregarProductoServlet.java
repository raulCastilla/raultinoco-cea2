package es.cea.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgregarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HtmlUtilities html=new HtmlUtilities("Nuevo Producto");
		pw.println(html.head);
		pw.println(html.cuerpo);
		if(request.getParameter("nombre")!=null&&request.getParameter("precio")!=null){
			ArrayList<Producto> p=(ArrayList<Producto>)request.getSession().getServletContext().getAttribute("catalogo");
			p.add(new Producto(request.getParameter("nombre"),Double.parseDouble(request.getParameter("precio"))));
			pw.println("Producto agregado<br>");
			pw.println("<a href='./nuevoproducto'>Producto nuevo</a>");
			pw.println("<a href='./catalogo'>Ver catalogo</a>");
		}
		else{
			
			pw.println("<form action='./nuevoproducto'>");
			pw.println("Nombre: <input type='text' name='nombre'>");
			pw.println("Precio: <input type='text' name='precio'>");
			pw.println("<input type='submit' value='Agregar'>");
			pw.println("</form>");
			pw.println("<a href='./catalogo'>Ver catalogo</a>");
		}
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
