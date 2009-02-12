package es.cea;

import java.util.List;

public interface Dato {
	public void agregar(Object o);
	public void eliminar(Object o);
	public Object obtener(Object o);
	List<Object> obtenerLista();
}
