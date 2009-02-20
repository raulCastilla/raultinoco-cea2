package es.cea.tags;



import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Prestamo;

public class EtiquetaLoginUsuario extends TagSupport{
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
			pw.println("<p>Login</p>");
			pw.println("<tr><td>Correo:</td><td><input type='text' name='correo' /></td></tr>" +
	                "<tr><td>Contraseña:</td><td><input type='password' name='contraseña'/></td></tr>" +
	                "<tr><td><input type='submit' value='Log In'/></td><td></td></tr></table></form>");
			pw.println("</table>");
			pw.println("<a href='./ControladorCatalogo'>Volver a catálogo</a><br>");
		}
		catch (IOException e) {
			throw new JspException(e);
		}
		return  SKIP_BODY;
	}
	

}

