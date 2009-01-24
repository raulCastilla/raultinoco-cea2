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
		ArrayList<Producto> lista=(ArrayList<Producto>)request.getSession().getServletContext().getAttribute("catalogo");
		response.setContentType("text/html");
		HtmlUtilities html=new HtmlUtilities("Catalogo");
		PrintWriter pw=response.getWriter();
		
		pw.println(html.head);
		pw.println(html.cuerpo);
		pw.println("<h4>Producto</h4><p>");
		for(int i=0;i<lista.size();i++){
			pw.println("<a href='./detalle?id="+lista.get(i).id+"'>"+lista.get(i).nombre+"</a><br>");
		}
		pw.println("</p><a href='./nuevoproducto'>Producto nuevo</a><br><br>");
		pw.println("<a href='./cerrar'>Cerrar sesion</a>");
		pw.println(html.fin);
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
