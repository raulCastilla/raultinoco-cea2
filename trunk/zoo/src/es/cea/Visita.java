package es.cea;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

public class Visita extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		if(request.getParameter("nombre")!=null&&request.getParameter("edad")!=null){
			if(request.getParameter("animal").equals("jirafa")){
				Jirafa newJ=new Jirafa(request.getParameter("nombre"),request.getParameter("edad"));
				List<Jirafa> j=(List<Jirafa>)request.getSession().getAttribute("jirafas");
				j.add(newJ);
			}
			if(request.getParameter("animal").equals("leon")){
				Leon newL=new Leon(request.getParameter("nombre"),request.getParameter("edad"));
				List<Leon> l=(List<Leon>)request.getSession().getAttribute("leones");
				l.add(newL);
			}
			if(request.getParameter("animal").equals("pantera")){
				Pantera newP=new Pantera(request.getParameter("nombre"),request.getParameter("edad"));
				List<Pantera> p=(List<Pantera>)request.getSession().getAttribute("panteras");
				p.add(newP);
			}
		}
		pw.println("<html><head><title>Zoologico</title></head>");
		pw.println("<body><div>");
		pw.println("Animales del zoo<a href='./jirafa'>Nueva Jirafa</a><a href='./pantera'>Nueva Pantera</a><a href='./leon'>Nuevo Leon</a><br><hr>");
		pw.println("Leones: "+request.getSession().getServletContext().getAttribute("leones")+"<br>");
		pw.println("Jirafas: "+request.getSession().getServletContext().getAttribute("jirafas")+"<br>");
		pw.println("Panteras: "+request.getSession().getServletContext().getAttribute("panteras")+"<br>");
		pw.println("<a href='./cerrar'>Cerrar sesion</a>");
		pw.println("</div></body></html>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
