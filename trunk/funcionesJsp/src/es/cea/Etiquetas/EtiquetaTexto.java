package es.cea.Etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class EtiquetaTexto extends EtiquetaGeneral {

	@Override
	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;

	}

	@Override
	public int doStartTag() throws JspException {
		
		JspWriter pw = pageContext.getOut();
		try{
			pw.println(getLabel()+": <input type='text' name='"+getNombre()+"'>");
		}
		catch (IOException e) {
			throw new JspException(e);
	
		}
		return SKIP_BODY;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return super.getLabel();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}

	@Override
	public void setLabel(String label) {
		// TODO Auto-generated method stub
		super.setLabel(label);
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		super.setNombre(nombre);
	}
	
	

}
