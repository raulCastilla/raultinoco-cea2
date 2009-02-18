package es.cea.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Usuario;

public class EtiquetaTablaUsuario extends TagSupport{
private static final long serialVersionUID = 1L;
	
	List<Usuario> list;

	public List<Usuario> getList() {
		return list;
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println("<table>");
			pw.println("<p>Lista de usuarios</p>");
			pw.println("<tr><th width='20%'>Usuario</th><th width='20%'>Mail</th><th width='20%'>Estado</th><th width='40%'>Accion</th></tr>");			
			for(Usuario usu:getList())
				pw.println("<tr><td>"+usu.getNombre()+"</td><td>"+usu.getCorreo()+"</td><td>"+usu.getRegistrado()+"</td>"+
						"<td><a href='#?nombre="+usu.getNombre()+"&aceptar=true'>Aceptar</a>"+
						"<a href='#?nombre="+usu.getNombre()+"&eliminar=true'>/Eliminar</a>");	
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
