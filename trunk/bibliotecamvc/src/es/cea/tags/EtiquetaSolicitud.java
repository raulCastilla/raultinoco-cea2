package es.cea.tags;



import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Prestamo;

public class EtiquetaSolicitud extends TagSupport{
private static final long serialVersionUID = 1L;

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println("<table>");
			pw.println("<p>Solicitud</p>");
			pw.println("<tr><td>Nombre:</td><td><input type='text' name='nombre' /></td></tr>" +
			"<tr><td>Correo:</td><td><input type='text' name='mail' /></td></tr>" +
	                "<tr><td>Contraseña:</td><td><input type='password' name='clave'/></td></tr>" +
	                "<tr><td><input type='submit' value='Solicitar registro'/></td><td></td></tr></table></form>");
			pw.println("</table>");
			pw.println("<a href='./ControladorCatalogo'>Volver a catálogo</a><br>");
		}
		catch (IOException e) {
			throw new JspException(e);
		}
		return  SKIP_BODY;
	}
	

}
