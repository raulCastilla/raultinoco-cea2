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
			pw.println("<table>");
			pw.println("<tr><th width='45%'>TÍTULO</th><th width='20%'>GÉNERO</th><th width='20%'>AUTOR</th><th width='15%'>VER</th></tr>");
			for(Libro lib:getList()){
				pw.println("<tr><td>"+lib.getTitulo()+
						"</td><td>"+lib.getGenero().getNombre()+
						"</td><td>"+lib.getAutor().getNombre()+"</td><td>"+
						"<a href='./ControladorDetalle?referencia="+lib.getReferencia()+"'>Ver</a></td></tr>");
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
