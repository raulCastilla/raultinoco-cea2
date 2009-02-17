package es.cea.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Genero;

public class EtiquetaTablaGenero extends TagSupport{

	private static final long serialVersionUID = 1L;
	List<Genero> list;
	
	
	public List<Genero> getList() {
		return list;
	}

	public void setList(List<Genero> list) {
		this.list = list;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		
		try{
			pw.println("<table>");
			pw.println("<tr><th width='80%'>GÉNERO</th><th width='20%'>EDICIÓN</th></tr>");
			for(Genero gen:getList())
				pw.println("<tr><td>"+gen.getNombre()+"</td>"+
						"<td><a href='#?nombre="+gen.getNombre()+"&eliminar=true'>Eliminar</a>"+
						"|<a href='#?nombre="+gen.getNombre()+"&modificar=true'>Modificar</a></td></tr>");
			pw.println("</table>");
		}
		catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	

}
