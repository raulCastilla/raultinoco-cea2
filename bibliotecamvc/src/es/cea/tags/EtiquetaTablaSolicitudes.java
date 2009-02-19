package es.cea.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Solicitud;

public class EtiquetaTablaSolicitudes extends TagSupport{
private static final long serialVersionUID = 1L;
	
	List<Solicitud> list;

	public List<Solicitud> getList() {
		return list;
	}

	public void setList(List<Solicitud> list) {
		this.list = list;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println("<table>");
			pw.println("<tr><th width='20%'id=tablaAdmin>Nombre</th><th width='20%'id=tablaAdmin>Aceptada</th><th width='40%'id=tablaAdmin>Accion</th></tr>");			
			for(Solicitud sol:getList())
				pw.println("<tr><td>"+sol.getUsuario()+"</td><td>"+sol.getAceptada()+"</td>"+
						"<td><a href='#?nombre="+sol.getUsuario()+"&aceptar=true'>Aceptar</a>"+
						"<a href='#?nombre="+sol.getUsuario()+"&eliminar=true'>/Eliminar</a>");	
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
