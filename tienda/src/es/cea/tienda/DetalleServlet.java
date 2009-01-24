package es.cea.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HtmlUtilities html=new HtmlUtilities("Detalles del producto");
		ArrayList<Producto> lista=(ArrayList<Producto>)request.getSession().getServletContext().getAttribute("catalogo");
		Producto p=(Producto)lista.get(Integer.parseInt(request.getParameter("id")));
		pw.println(html.head);
		pw.println(html.cuerpo);
		pw.println("Id: "+p.id+"<br>");
		pw.println("Nombre: "+p.nombre+"<br>");
		pw.println("Precio: "+p.precio+"<br>");
		pw.println("<a href='./catalogo'>Ir al catalogo</a>");
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
