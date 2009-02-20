package es.cea.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Libro;
import es.cea.dao.modelo.Prestamo;

public class EtiquetaLibroPrestamo extends TagSupport{
	private static final long serialVersionUID = 1L;
	Prestamo prestamo;
	
	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setLibro(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();

		try {
			pw.println("<table>");
			pw.println("<p>Libro préstado</p>");
			pw.println("<tr><th width='20%'id=tablaPréstamo>Título</th><th width='20%'id=tablaPréstamo>Fecha inicio</th><th width='20%'id=tablaPréstamo>Fecha fín</th></tr>");
			pw.println("<tr><td>" + prestamo.getLibro() + "</td>" + "<tr><td>"
					+ prestamo.getFechaInicio() + "</td>" + "<tr><td>"
					+ prestamo.getFechaFin() + "</td>" + "<tr><td>");
			pw.println("</table>");
			pw.println("<a href='./ControladorCatalogo'>Volver a catálogo</a><br>");
		} catch (IOException e) {
			throw new JspException(e);
		}
		
	return SKIP_BODY;
	}


	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
	
	
}
