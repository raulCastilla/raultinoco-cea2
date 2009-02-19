package es.cea.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Libro;

import es.cea.dao.modelo.Libro;

public class EtiquetaTablaLibroAdministrador extends TagSupport {
	private List<Libro> list;
	
	public List<Libro> getList() {
		return list;
	}

	public void setList(List<Libro> list) {
		this.list = list;
	}

	private static final long serialVersionUID = 1L;
	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println("<table id=tablaAdmin>");
			pw.println("<tr><th width='45%'>Título</th><th width='20%'>Género</th><th width='20%'>Autor</th><th width='15%'>Ver</th></tr>");
			for(Libro lib:getList()){
				pw.println("<tr><td>"+lib.getTitulo()+
						"</td><td>"+lib.getGenero().getNombre()+
						"</td><td>"+lib.getAutor().getNombre()+"</td><td>"+
						"<a href='./detalle?ref="+lib.getReferencia()+"'>Ver</a>"+
						"|<a href='./#="+lib.getReferencia()+"'>eliminar</a></td></tr>");
			}
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

