package es.cea.Tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class EtiquetaMenuUsuario extends EtiquetaGeneral {

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println(getLabel()+"<a href='./'>CATALOGO</a>");
			pw.println(getLabel()+"<a href='./'>PRESTAMOS</a>");
			pw.println(getLabel()+"<a href='./'>SOLICITAR REGISTRO</a>");
			pw.println(getLabel()+"<a href='./'>LOG IN</a>");
			pw.println(getLabel()+"<a href='./'>CERRAR SESION</a>");
			pw.println(getLabel()+"<a href='./'>ADMINISTRAR</a>");
			//
		}
		catch (IOException e) {
			throw new JspException(e);	
		}
		return SKIP_BODY;
	}
	

}
