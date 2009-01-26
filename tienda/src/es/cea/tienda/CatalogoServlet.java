package es.cea.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HtmlUtilities html=new HtmlUtilities("Catalogo");
		ArrayList<Producto> lista=(ArrayList<Producto>)request.getSession().getServletContext().getAttribute(AtributosConstantes.catalogo.toString());
		
		pw.println(html.head);
		pw.println(html.cuerpo);
		for(Producto p:lista){
			pw.println("<a href='./detalle?id="+p.id+"'>"+p.nombre+"</a><br>");
		}
		pw.println("<a href='./carrito'>Ir a mi carrito</a><br>");
		pw.println("<a href='./cerrar'>Cerrar sesion</a>");
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
