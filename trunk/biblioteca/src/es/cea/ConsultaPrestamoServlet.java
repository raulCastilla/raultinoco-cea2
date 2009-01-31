package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsultaPrestamoServlet extends HttpServlet {
	
		private static final long serialVersionUID = 1L;
		
		
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                
                HtmlUtilities html = new HtmlUtilities("Prestamos");
                writer.println(html.head);
                writer.println(html.cuerpo);
                
                Prestamo[] prestamos = (Prestamo[]) request.getSession().getAttribute(AtributosConstantes.prestamosUsuario.toString());
        
                writer.println("<table width='100%' border='3'>");
                writer.println("<tr><td><b>REFERENCIA</b></td>" +
                               "<td><b>TITULO</b></td>" +
                               "<td><b>INICIO DEL PRESTAMO</b></td>" + 
                               "<td><b>FIN DEL PRESTAMO</b></td>" +
                               "</tr>");
                
                for (Prestamo prest : prestamos) {
                        writer.println("<tr><td>"+prest.libro.referencia+"</td>" +
                                       "<td>"+prest.libro.titulo+"</td>" +
                                       "<td>"+prest.fechaInicio+"</td>" +
                                       "<td>"+prest.fechaFin+"</td></tr>");       
                }
                
                writer.println("</table>");
                writer.println("<a href='./biblioteca'>Volver a Biblioteca</a>");
                writer.println(html.fin);
                writer.close();
                
                
        
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doGet(request, response);
        }
}
