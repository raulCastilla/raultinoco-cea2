package es.cea.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class EtiquetaFormulario extends TagSupport{
	protected String url;
	protected String method;
	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println("<form action='"+this.getUrl()+"'method='"+this.getMethod()+"'>");
		}
		catch (IOException e) {
			throw new JspException(e);
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println("<input type='submit'></form>");
		}
		catch (IOException e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
}
