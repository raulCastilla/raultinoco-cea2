package es.cea;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MonedaTag extends TagSupport{
	protected Double valor=27.14;
	protected String patron = "€";
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println(this.valor+" "+this.patron);
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getPatron() {
		return patron;
	}

	public void setPatron(String patron) {
		this.patron = patron;
	}
	
}
