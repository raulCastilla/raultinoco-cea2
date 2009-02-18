package es.cea.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Prestamo;

public class EtiquetaTablaPrestamo extends TagSupport{
	private static final long serialVersionUID = 1L;
		
		List<Prestamo> list;

		public List<Prestamo> getList() {
			return list;
		}
		public void setList(List<Prestamo> list) {
			this.list = list;
		}
		@Override
		public int doStartTag() throws JspException {
			JspWriter pw = pageContext.getOut();
			try{
				pw.println("<table>");
				pw.println("<p>Lista de prestamos</p>");
				pw.println("<tr><th width='20%'id=tablaAdmin>Usuario</th><th width='20%'id=tablaAdmin>Libro</th><th width='20%'id=tablaAdmin>Fecha Inicio</th><th width='20%'id=tablaAdmin>Fecha Fin</th></tr>");
				for(Prestamo pres:getList())
					pw.println("<tr><td>"+pres.getUsuario()+"</td>"+
							"<tr><td>"+pres.getLibro()+"</td>"+
							"<tr><td>"+pres.getFechaInicio()+"</td>"+
							"<tr><td>"+pres.getFechaFin()+"</td>");						
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