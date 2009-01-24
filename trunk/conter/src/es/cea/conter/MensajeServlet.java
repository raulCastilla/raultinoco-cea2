package es.cea.conter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MensajeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		if(request.getParameter("texto")!=""){
			ArrayList<String> lista=(ArrayList<String>)request.getSession().getServletContext().getAttribute("chat");
			lista.add(request.getParameter("texto")+"<br>");
		}
		//Contador c=(Contador)request.getSession().getServletContext().getAttribute("contador");
		//c.usuario++;
		//request.getSession().setAttribute("usuario", c.usuario);
		pw.println("<html><head><title>Escribir mensajes</title></head>");
		pw.println("<body<div><h2>Escribir mensaje</h2><hr>");
		pw.println("<form action='./mensaje' method='post'>");
		pw.println("<input type='text' name='texto'>");
		pw.println("<input type='submit' value='Enviar'>");
		pw.println("</form>");
		pw.println("</div></body></html>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
