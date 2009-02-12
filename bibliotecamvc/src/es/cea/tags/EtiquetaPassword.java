package es.cea.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class EtiquetaPassword extends EtiquetaGeneral{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7497055265208609063L;
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
	@Override
	public int doStartTag() throws JspException {

		JspWriter pw = pageContext.getOut();
		try{
			pw.println(getLabel()+": <input type='password' name='"+getNombre()+"'>");
		}
		catch (IOException e) {
			throw new JspException(e);	
		}
		return SKIP_BODY;
	}	
}
