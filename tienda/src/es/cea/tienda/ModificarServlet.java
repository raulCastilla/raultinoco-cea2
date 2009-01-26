package es.cea.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HtmlUtilities html=new HtmlUtilities("Modificar");
		List<Producto> lista=(List<Producto>)request.getSession().getServletContext().getAttribute(AtributosConstantes.catalogo.toString());
		Producto p=null;
		pw.println(html.head);
		pw.println(html.cuerpo);
		for(Producto tmp:lista) if(tmp.id.equals(Integer.parseInt(request.getParameter("id")))) p=tmp;
		if(p==null){
			ProductoNoExisteException noExiste=new ProductoNoExisteException("Id seleccionado: "+Integer.parseInt(request.getParameter("id")));
			request.setAttribute("error", noExiste);
			throw noExiste;
		}
		
		if(request.getParameter("modificar")!=null){
			p.nombre=request.getParameter("nombre");
			p.precio=Double.valueOf(request.getParameter("precio"));
			pw.println("<b>PRODUCTO MODIFICADO!:</b>"+p.nombre+"<br>");
            pw.println("<hr><a href='./catalogo'>Volver a catalogo</a>");
		}
		else{
			pw.println("DETALLE DE PRODUCTO A MODIFICAR      :"+p.nombre+"<br>");
            pw.println("<form action='./modificar' method='post'>");
            pw.println("<b>NOMBRE:</b> <input type='text' name='nombre' value='"+p.nombre+"'/>");
            pw.println("<b>PRECIO:</b> <input type='text' name='precio' value='"+p.precio+"'/>");
            pw.println("<input type='hidden' name='id' value='"+p.id+"'/>");
            pw.println("<input type='submit' name='modificar' value='modificar'/>");
            pw.println("</form>");

		}
		
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
