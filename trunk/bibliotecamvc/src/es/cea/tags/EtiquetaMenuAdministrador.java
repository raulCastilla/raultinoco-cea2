package es.cea.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class EtiquetaMenuAdministrador extends EtiquetaGeneral {

	/**
	 * 
	 */
	private static final long serialVersionUID = -106702292721192090L;

	@Override
	public int doEndTag() throws JspException {

		JspWriter pw = pageContext.getOut();
		try{
			pw.println("<a href='./>LIBROS</a>");
			pw.println("<a href='./>GENEROS</a>");
			pw.println("<a href='./>AUTORES</a>");
			pw.println("<a href='./>USUARIOS</a>");
			pw.println("<a href='./>PRESTAMOS</a>");
			pw.println("<a href='./>SOLICITUDES</a>");
			pw.println("<a href='./>CERRAR SESION</a>");
		}
		catch (IOException e) {
			throw new JspException(e);	
		}
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {

		
		return SKIP_BODY;
	}
	

}
