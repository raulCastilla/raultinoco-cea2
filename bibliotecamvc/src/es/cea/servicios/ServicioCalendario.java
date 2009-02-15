package es.cea.servicios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.cea.excepcion.FechaNoValidaException;

public class ServicioCalendario {

	public ServicioCalendario() {
		super();
	}
	
	public String calendarioToString(Calendar cal){
		
		SimpleDateFormat formater = new SimpleDateFormat();
		formater.applyPattern("dd/MM/yyyy");
		return formater.format(cal.getTime());
		
	}
	
	public Calendar stringToCalendario(String fecha) throws FechaNoValidaException{
		Calendar cal=Calendar.getInstance();
		
		if(!comprobarFormatoFecha(fecha)) 
			throw new FechaNoValidaException();
		else{
			String[] campos=fecha.split("/");
			cal.set(Calendar.DATE, Integer.parseInt(campos[0]));
			cal.set(Calendar.MONTH, Integer.parseInt(campos[1])-1);
			cal.set(Calendar.YEAR, Integer.parseInt(campos[2]));
		}
		return cal;
	}
	
	public Integer getIntervaloFecha(Calendar ini,Calendar fin){
		return fin.get(Calendar.DAY_OF_YEAR)-ini.get(Calendar.DAY_OF_YEAR);
	}
	
	private Boolean comprobarFormatoFecha(String fecha){
		Boolean valida=false;
		Pattern p = Pattern.compile("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]");
		String[] fields = fecha.split("/");
		Matcher m = p.matcher(fecha);
		if(m.matches()&&Integer.parseInt(fields[0])<32&&Integer.parseInt(fields[1])<13) valida=true;
		return valida;
	}
}
