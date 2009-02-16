package es.cea.tags;

import java.util.List;

import javax.servlet.jsp.tagext.TagSupport;

import es.cea.dao.modelo.Libro;

public class EtiquetaTabla extends TagSupport{
	List<Libro> list;

	public List<Libro> getList() {
		return list;
	}

	public void setList(List<Libro> list) {
		this.list = list;
	}
	
}
