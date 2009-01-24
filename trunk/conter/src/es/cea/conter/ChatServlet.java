package es.cea.conter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Contador cont=(Contador)request.getSession().getServletContext().getAttribute("contador");
		pw.println("<html><head><meta http-equiv='Refresh'content='2'><title>Chat</title></head>");
		pw.println("<body<div><h2>Chat</h2><hr>");
		pw.println("<h3>"+cont.usuario.toString()+"</h3><br>");
		pw.println(request.getSession().getServletContext().getAttribute("chat"));
		pw.println("<hr></div></body></html>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
