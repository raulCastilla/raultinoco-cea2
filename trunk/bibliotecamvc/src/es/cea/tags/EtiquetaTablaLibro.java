package es.cea.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Libro;

public class EtiquetaTablaLibro extends TagSupport{
	
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
			pw.println("<table border='1'>");
			pw.println("<tr><th>TÍTULO</th><th>GÉNERO</th><th>AUTOR</th><th>VER</th></tr>");
			for(Libro lib:getList()){
				pw.println("<tr><th>"+lib.getTitulo()+
						"</th><th>"+lib.getGenero().getNombre()+
						"</th><th>"+lib.getAutor().getNombre()+"</th><th>"+
						"<a href='./detalle?ref="+lib.getReferencia()+"'>Ver</a></th></tr>");
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
