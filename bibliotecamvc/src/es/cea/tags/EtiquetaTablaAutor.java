package es.cea.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Autor;

public class EtiquetaTablaAutor extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	List<Autor> list;

	public List<Autor> getList() {
		return list;
	}

	public void setList(List<Autor> list) {
		this.list = list;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{			
			pw.println("<table>");	
			pw.println("<p>Lista de autores</p>");
			pw.println("<tr><th width='80%'id=tablaAdmin>Autor</th><th width='20%'id=tablaAdmin>Edición</th></tr>");
			for(Autor aut:getList())
				pw.println("<tr><td>"+aut.getNombre()+"</td>"+
						"<td><a href='#?nombre="+aut.getNombre()+"&eliminar=true'>Eliminar</a>"+
						"|<a href='#?nombre="+aut.getNombre()+"&modificar=true'>Modificar</a></td></tr>");
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
