package es.cea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PruebaDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext sc;

	public void init(ServletConfig config) throws ServletException {
		sc=config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html>"); 
        out.println("<head><title>Ejemplo de RequestDispatcher</title></head>"); 
        out.println("<body bgcolor=\"#FFFF9D\"><FONT color=\"#000080\" FACE=\"Arial, Helvetica,Times\" SIZE=2>"); 
        out.println("<CENTER><H3>Ejemplo de RequestDispatcher</H3></CENTER><HR>"); 
        out.println("<p>Este servlet (el primero) usará un RequestDispatcher (otro servlet)</p>"); 
        
        /******** 
         * En vez de usar getServletContext().getRequestDispatcher() aplico sc.getRequestDispatcher(), 
         * donde sc se obtiene en init(). 
         * La razón es que el primer método en ocasiones falla, de hecho, la documentación de SUN 
         * recomienda el segundo método. 
         *********/ 
        
        RequestDispatcher dispatcher = sc.getRequestDispatcher("/requestimagen"); 
        if (dispatcher!=null){
                if(request.getParameter("metodo").equals("include")){ 
                        dispatcher.include(request, response);
                }
                else{ 
                        dispatcher.forward(request, response); 
                }
        } 
        else 
                out.println("<p>No se ha encontrado RequestDispatcher</p>"); 
        
        out.println("<p>Final del primer servlet</p>"); 
        out.println("</font></body></html>"); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
