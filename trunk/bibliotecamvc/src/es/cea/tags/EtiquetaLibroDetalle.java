package es.cea.tags;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Libro;
import es.cea.dao.modelo.Prestamo;
import es.cea.dao.modelo.Usuario;
import es.cea.recursos.AtributosConstantes;

public class EtiquetaLibroDetalle extends TagSupport {
	private static final long serialVersionUID = 1L;

	Libro libro;

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();

		try {
			pw.println("<table>");
			pw.println("<p>Detalle de su libro</p>");
			pw.println("<tr><th width='20%'id=tablaDetalle>Título</th><th width='20%'id=tablaDetalle>Referencia</th><th width='20%'id=tablaDetalle>Fecha de publicación</th><th width='20%'id=tablaDetalle>Autor</th><th width='20%'id=tablaDetalle>Género</th><th width='20%'id=tablaDetalle>¿Prestado?</th></tr>");
			pw.println("<tr><td>" + libro.getTitulo() + "</td>" + "<tr><td>"
					+ libro.getReferencia() + "</td>" + "<tr><td>"
					+ libro.getFechaPublicacion() + "</td>" + "<tr><td>"
					+ libro.getAutor() + "</td>" + "<tr><td>"
					+ libro.getGenero() + "</td>" + "<tr><td>");
			pw.println("</table>");

			if (libro.getPrestado().booleanValue() == false) {
				pw.println("<a href='./ControladorPrestamo?referencia="+libro.getReferencia()+"'>Realizar prestamo</a><br>");
			}
		} catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}