package es.cea;

import java.util.List;

public class DatoGenero implements Dato{
	
	private static DatoGenero datoGenero= new DatoGenero();
	private List<Genero> generos = ListasDB.getListasDB().getGeneros();
	private DatoGenero(){}
	
	public static DatoGenero getInstance(){
		return datoGenero;
	}
	
	public void agregar(Object o){
		if(!generos.contains((Genero)o))
			generos.add((Genero)o);
		
	}

	public void eliminar(Object o) {
		// TODO Auto-generated method stub
		
	}

	public Genero obtener(Object o) {
		return (Genero)o;
	}

	public List<Object> obtenerLista() {
		return null;
	}

}
