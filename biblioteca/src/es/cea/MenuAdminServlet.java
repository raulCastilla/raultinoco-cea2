package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> libros = (List<Libro>)request.getSession().getServletContext().getAttribute(AtributosConstantes.libros.toString());
		if(request.getParameter("genero")!=null){
			Collections.sort(libros,new ComparatorGenero());
		}
		else if(request.getParameter("autor")!=null){
			Collections.sort(libros, new ComparatorAutor());
		}
		else{
			Collections.sort(libros);
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		HtmlUtilities html = new HtmlUtilities("Menu de Administracion");
		String prest="";
		pw.println(html.head);
		pw.println(html.cuerpo);
		pw.println("<a href='./menuadmin?genero=true'>Ordenar libros por genero</a>/<a href='./menuadmin?autor=true'>Ordenar libros por autor</a>/<a href='./crear>A-adir un libro nuevo</a><br>");
		pw.println("<table border='1'>");
		pw.println("<tr><td>T&Iacute;TULO</td><td>G&Eacute;NERO</td><td>AUTOR</td><td>DETALLES</td><td>ALQUILADO</td><td>MODIFICAR</td><td>ELIMINAR</td></tr>");
		for(Libro tmp : libros){
			prest = (tmp.prestado)?"SI":"NO";
			pw.println("<tr><td>"+tmp.titulo+"</td><td>"+tmp.genero+"</td><td>"+tmp.autor+"</td><td><a href='./detalle?ref="+tmp.referencia+"'>Ver</a></td><td>"+prest+"</td><td><a href='./modificar?ref="+tmp.referencia+"'>Modificar</a></td><td><a href='./eliminar?ref="+tmp.referencia+"'>Eliminar</a></td></tr>");
		}
		pw.println("</table>");
		//pw.println("<a href='./'>Consultar libros reservados</a><br>");
		//pw.println("<a href='./'>Prestamos solicitados</a><br>");
		//pw.println("<a href='./'>Registros solicitados</a><br>");
		pw.println(html.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	

}
