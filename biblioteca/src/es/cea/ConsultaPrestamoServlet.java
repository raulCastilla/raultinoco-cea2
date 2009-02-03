package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsultaPrestamoServlet extends HttpServlet {
	
		private static final long serialVersionUID = 1L;
		
		
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                writer.println(HtmlUtilities.head);
                writer.println(HtmlUtilities.cuerpo);
                writer.println(HtmlUtilities.menuUser);
                
                Usuario user = (Usuario)request.getSession().getAttribute(AtributosConstantes.usuarioRegistrado.toString());
               
                writer.println("<h3 style='color: #FF0000'>MIS PRESTAMOS</h3>");
                writer.println("<table width='100%' border='3'>");
                writer.println("<tr><td><b>REFERENCIA</b></td>" +
                               "<td><b>TITULO</b></td>" +
                               "<td><b>INICIO DEL PRESTAMO</b></td>" + 
                               "<td><b>FIN DEL PRESTAMO</b></td>" +
                               "</tr>");
                if(user!=null){
                	for (Prestamo prest : user.prestamos) {
                		if(prest!=null){
                			writer.println("<tr><td>"+prest.libro.referencia+"</td>" +
                                       "<td>"+prest.libro.titulo+"</td>" +
                                       "<td>"+prest.fechaInicio.get(Calendar.DATE)+"/"+(prest.fechaInicio.get(Calendar.MONTH)+1)+"/"+prest.fechaInicio.get(Calendar.YEAR)+"</td>" +
                                       "<td>"+prest.fechaFin.get(Calendar.DATE)+"/"+(prest.fechaFin.get(Calendar.MONTH)+1)+"/"+prest.fechaFin.get(Calendar.YEAR)+"</td></tr>");
                		}
                	}
                }
                
                writer.println("</table>");
                writer.println(HtmlUtilities.fin);
                writer.close();
                
                
        
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request, response);
        }
}


