package es.cea.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HtmlUtilities html=new HtmlUtilities("Crear Producto");
		List<Producto> lista=(List<Producto>)request.getSession().getServletContext().getAttribute(AtributosConstantes.catalogo.toString());
		pw.println(html.head);
		pw.println(html.cuerpo);
		if(request.getParameter("crear")!=null){
			Producto nuevo= new Producto(Integer.parseInt(request.getParameter("id")),Double.parseDouble(request.getParameter("precio")),request.getParameter("nombre"));
			lista.add(nuevo);
			pw.println("SU PRODUCTO HA SIDO AGREGADO<br>");
			pw.println("<a href='./catalogo'>Volver al catalog</a>");
		}
		else{
			pw.println("<form action='./crear?crear=true' method='post'>");
			pw.println("<b>ID:</b><input type='text' name='id' />");
			pw.println("<b>NOMBRE:</b> <input type='text' name='nombre' />");
			pw.println("<b>PRECIO:</b> <input type='text' name='precio' />");
			pw.println("<input type='submit' value='Crear' />");
			pw.println("</form>");
		}
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
