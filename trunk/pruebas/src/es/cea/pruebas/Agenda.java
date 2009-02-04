package es.cea.pruebas;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	List<Persona> agenda=new ArrayList<Persona>();
	public Agenda(){
		super();
		agenda.add(new Persona("pepe","millan"));
		agenda.add(new Persona("juan","perez"));
		agenda.add(new Persona("ana","ruiz"));
	}
	
	
	public Boolean exiteModo1(String nombre,String apellido){
		Boolean existe=false;
		for(Persona tmp:agenda){
			if(tmp.nombre.equals(nombre)&&tmp.apellidos.equals(apellido)){
				existe=true;
			}
		}
		return existe;
	}
	
	public Boolean buscarModo2(String nombre,String apellido){
		Boolean existe=false;
		Persona p=new Persona(nombre,apellido);
		if(agenda.contains(p)) existe=true; 
		return existe;
	}
}
