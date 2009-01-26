package es.cea.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HtmlUtilities html=new HtmlUtilities("Eliminar producto");
		pw.println(html.head);
		pw.println(html.cuerpo);
		List<Producto> lista=(List<Producto>)request.getSession().getServletContext().getAttribute(AtributosConstantes.catalogo.toString());
		Producto p=null;
		for(Producto v:lista) if(v.id.equals(Integer.parseInt(request.getParameter("id")))) p=v;
		if(p==null){
			ProductoNoExisteException noExiste=new ProductoNoExisteException("Id seleccionado: "+Integer.parseInt(request.getParameter("id")));
			request.setAttribute("error", noExiste);
			throw noExiste;
		}
		if(request.getParameter("confirmar")!=null){
			lista.remove(Integer.parseInt(request.getParameter("id")));
			 pw.println("<b>PRODUCTO ELIMINADO:</b>"+p.nombre+"<br>");
             pw.println("<a href='./catalogo'>Volver a catalogo</a>");
		}
		else{
			 pw.println("<b>DETALLE DE PRODUCTO A ELIMINAR :</b>"+p.nombre+"<br>");
			 pw.println("<b>NOMBRE: </b>"+p.nombre+"<br>");
			 pw.println("<b>PRECIO: </b>"+p.precio+"<br>");
			 pw.println("<hr><a href='./delete?id="+p.id+"&confirmar=true'>Confirmar borrar</a>");
		}
		pw.println(html.fin);
		pw.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
