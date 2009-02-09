package es.cea;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		ComprobarFecha testFecha = new ComprobarFecha();
		if(!testFecha.comprobarFormatoFecha(fecha)) throw new FechaNoValidaException();
		else{
			String[] campos=fecha.split("/");
			cal.set(Calendar.DATE, Integer.parseInt(campos[0]));
			cal.set(Calendar.MONTH, Integer.parseInt(campos[1])-1);
			cal.set(Calendar.YEAR, Integer.parseInt(campos[2]));
		}
		return cal;
	}
	
	public Integer getIntervalo(Calendar ini,Calendar fin){
		return fin.get(Calendar.DAY_OF_YEAR)-ini.get(Calendar.DAY_OF_YEAR);
	}
	
}
