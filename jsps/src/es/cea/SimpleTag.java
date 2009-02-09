package es.cea;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SimpleTag extends TagSupport{
	protected String color="#FF0000";
	protected String mensaje="Hola eqtiqueta";
	@Override
	public int doEndTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println("<font color='"+this.color+"'>");
			pw.println(this.mensaje);
			pw.println("</font>");
		}
		catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}
