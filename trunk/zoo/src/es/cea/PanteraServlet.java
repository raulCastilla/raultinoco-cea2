package es.cea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PanteraServlet
 */
public class PanteraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><head><title>Pantera</title></head>");
		pw.println("<body><div>");
		pw.println("<form action='./visita'>");
		pw.println("<input type='text' name='nombre'>");
		pw.println("<input type='text' name='edad'>");
		pw.println("<input type='hidden' name='animal' value='pantera'>");
		pw.println("<input type='submit'>");
		pw.println("</form>");
		pw.println("</div></body></html>");
		pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
