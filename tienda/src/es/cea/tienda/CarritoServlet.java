package es.cea.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HtmlUtilities html = new HtmlUtilities("Mi Carrito");
		pw.println(html.head);
		pw.println(html.cuerpo);
		List<Producto> carrito=(List<Producto>)request.getSession().getAttribute(AtributosConstantes.carrito.toString());
		pw.println("<table border='1' bordercolor='orange'>");
		pw.println("<tr><td>NOMBRE</td><td>PRECIO</td></tr>");
		for(Producto p:carrito) pw.println("<tr><td>"+p.nombre+"</td><td>"+p.precio+"</td></tr>");
		pw.println("</table>");
		pw.println("<br><a href='./catalogo'>Ir al catalogo</a>");
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
