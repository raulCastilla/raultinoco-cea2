package es.cea.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import es.cea.dao.modelo.Libro;

public class EtiquetaTablaLibro extends EtiquetaTabla{

	private static final long serialVersionUID = 1L;
	JspWriter pw = pageContext.getOut();
	@Override
	public int doStartTag() throws JspException {
		try{
			pw.println("<table>");
			pw.println("<tr><th>TÍTULO</th><th>GÉNERO</th><th>AUTOR</th><th>VER</th></tr>");
			for(Libro lib:getList()){
				pw.println("<tr><th>"+lib.getTitulo()+
						"</th><th>"+lib.getGenero().getNombre()+
						"</th><th>"+lib.getAutor().getNombre()+"</th><th>"+
						"<a href='./detalle?ref="+lib.getReferencia()+"'</th></tr>");
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
