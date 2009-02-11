package es.cea.Etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class EtiquetaRadioButton extends EtiquetaGeneral{
	String[] opciones;
	
	

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println(getLabel()+"<br>");
			for(String op:this.getOpciones()){
				pw.println("<input type='radio' name='"+getNombre()+"' value='"+op+"'>");
			}
		}
		catch (IOException e) {
			throw new JspException(e);
	
		}
		return SKIP_BODY;
	}

	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}
	
}
