package es.cea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComprobarFecha {

	public ComprobarFecha() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Boolean comprobarFormatoFecha(String fecha){
		Boolean valida=false;
		Pattern p = Pattern.compile("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]");
		String[] fields = fecha.split("/");
		Matcher m = p.matcher(fecha);
		if(m.matches()&&Integer.parseInt(fields[0])<32&&Integer.parseInt(fields[1])<13) valida=true;
		return valida;
	}
}
