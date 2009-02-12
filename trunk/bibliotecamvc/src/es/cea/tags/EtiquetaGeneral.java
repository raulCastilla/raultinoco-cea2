package es.cea.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class EtiquetaGeneral extends TagSupport{

	private static final long serialVersionUID = 2720833936383567822L;
	
	protected String label;
	protected String nombre;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
