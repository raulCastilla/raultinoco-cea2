package es.cea;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TraductorMapa extends TagSupport{
	Map<String,String> valor2 = new HashMap<String, String>();
	public Map<String, String> getValor2() {
		return valor2;
	}

	public void setValor2(Map<String, String> valor2) {
		this.valor2 = valor2;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		Set set=valor2.keySet();
		Iterator<String> it=set.iterator();
		String val;
		try{
			pw.println("<table border='1'>");
			while(it.hasNext()){
				val=it.next();
				pw.println("<tr><td>"+val+"</td><td>"+valor2.get(val)+"</td></tr>");
			}
			pw.println("</table>");
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
	

}
