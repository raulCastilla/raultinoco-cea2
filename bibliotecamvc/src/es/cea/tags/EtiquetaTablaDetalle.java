package es.cea.tags;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Libro;
import es.cea.dao.modelo.Prestamo;
import es.cea.dao.modelo.Usuario;
import es.cea.recursos.AtributosConstantes;


public class EtiquetaTablaDetalle extends TagSupport{
private static final long serialVersionUID = 1L;
	
	List<Libro> list;

	public List<Libro> getList() {
		return list;
	}
	
	public void setList(List<Libro> list) {
		this.list = list;
	}
	
	public int doStartTag() throws JspException {
		JspWriter pw = pageContext.getOut();
		try{
			pw.println("<table>");
			pw.println("<p>Detalle de su libro</p>");
			pw.println("<tr><th width='20%'id=tablaDetalle>Título</th><th width='20%'id=tablaDetalle>Referencia</th><th width='20%'id=tablaDetalle>Fecha de publicación</th><th width='20%'id=tablaDetalle>Autor</th><th width='20%'id=tablaDetalle>Género</th><th width='20%'id=tablaDetalle>¿Prestado?</th></tr>");
			for(Libro lib:getList()){
				//condicion para pillar la referencia del libro seleccionado
				//if(){ no request
			}
				//	pw.println("<tr><td>"+lib.getTitulo()+"</td>"+
				//		"<tr><td>"+lib.getReferencia()+"</td>"+
				//		"<tr><td>"+lib.getFechaPublicacion()+"</td>"+
				//		"<tr><td>"+lib.getAutor()+"</td>"+
				//		"<tr><td>"+lib.getGenero()+"</td>"+	
				//		"<tr><td>"+lib.getPrestado()+"</td>");	
				//	pw.println("</table>");
			
			// if(li){
			  //  	pw.println("<a href='ControladorPrestamo'>Realizar prestamo</a><br>");
			   //}
			
				
				
		}
		catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}
	
	
	
	
	
	
	
	
}