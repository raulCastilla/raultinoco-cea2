package es.cea.tienda;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
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
		pw.println(html.head);
		pw.println(html.cuerpo);
		List<Producto> lista=(List<Producto>)request.getSession().getServletContext().getAttribute(AtributosConstantes.catalogo.toString());
		List<Producto> carrito=(List<Producto>)request.getSession().getAttribute(AtributosConstantes.carrito.toString());
		Integer id=Integer.parseInt(request.getParameter("id"));
		Producto p=null;
		for(Producto select:lista){
			if(select.id.equals(id)) p=select;
		}
		if(p==null){
			ProductoNoExisteException noExiste=new ProductoNoExisteException("Id seleccionado: "+id);
			request.setAttribute("error", noExiste);
			throw noExiste;
		}
		if(request.getParameter("carrito")!=null)
			if(request.getParameter("carrito").equals("true")) carrito.add(p);
			else if(request.getParameter("carrito").equals("false")) carrito.remove(p);	
		pw.println("<h4>Detalles</h4>");
		pw.println("ID: "+p.id+"<br>");
		pw.println("NOMBRE: "+p.nombre+"<br>");
		pw.println("PRECIO: "+p.precio+"<br>");
		if(!carrito.contains(p))
			pw.println("<a href='./detalle?id="+p.id+"&carrito=true'>INCLUIR A CARRITO</a><br>");
		else
			pw.println("<a href='./detalle?id="+p.id+"&carrito=false'>ELIMINAR DEL CARRITO</a><br>");
		
		pw.println("<a href='./catalogo'>Ir al catalogo</a><br>");
		pw.println("<a href='./carrito'>Ir a mi carrito</a>");
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
