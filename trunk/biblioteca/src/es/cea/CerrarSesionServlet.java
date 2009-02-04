package es.cea;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CerrarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		pw.println(HtmlUtilities.head);
		pw.println(HtmlUtilities.cuerpo);
		pw.println(HtmlUtilities.menuUser);
		if(request.getSession().getAttribute(AtributosConstantes.usuarioRegistrado.toString())!=null){
			request.getSession().invalidate();
			pw.println("<p>SESIÓN CERRADA</p>");
		}
		else{
			pw.println("<p>NO HAY NINGUNA SESIÓN INICIADA</p>");
		}
		pw.println(HtmlUtilities.fin);
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
