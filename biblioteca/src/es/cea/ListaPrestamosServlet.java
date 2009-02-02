package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaPrestamosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Prestamo> prestamos=(List<Prestamo>)request.getSession().getServletContext().getAttribute(AtributosConstantes.prestamos.toString());
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuAdmin);
		pw.println("<h3 style='color: #FF0000'>LISTA DE PRESTAMOS</h3>");
		pw.println("<table border='1'");
		pw.println("<tr><td>LIBRO</td><td>USUARIO</td><td>FECHA DE INICIO</td><td>FECHA DE FIN</td></tr>");
		
		for(Prestamo p:prestamos){
			pw.println("<tr><td>"+p.libro.titulo+"</td><td>"+p.usuario.nombre+"</td><td>"+
					p.fechaInicio.get(Calendar.DATE)+"/"+(p.fechaInicio.get(Calendar.MONTH)+1)+
					"/"+p.fechaInicio.get(Calendar.YEAR)+"</td><td>"+p.fechaFin.get(Calendar.DATE)+"/"+(p.fechaFin.get(Calendar.MONTH)+1)+
					"/"+p.fechaFin.get(Calendar.YEAR)+"</td></tr>");
		}
			
		pw.println("</table>");
		pw.println(HtmlUtilities.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
