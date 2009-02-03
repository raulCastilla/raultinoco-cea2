package es.cea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CerrarAdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().getServletContext().setAttribute(AtributosConstantes.administrador.toString(), null);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuAdmin);
		pw.println("<h3 style='color: #FF0000'>CERRAR SESIÓN ADMINISTRADOR</h3>");
		pw.println("<a href='../'>Ir al catálogo</a>");
		pw.println(HtmlUtilities.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
