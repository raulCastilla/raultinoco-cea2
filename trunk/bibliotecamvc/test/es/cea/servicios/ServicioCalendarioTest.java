package es.cea.servicios;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import es.cea.excepcion.FechaNoValidaException;

public class ServicioCalendarioTest {
	
	@Test
	public void calendarioToString(){
		
		Calendar cal = Calendar.getInstance();
		String fecha;
		Pattern p = Pattern.compile("[0-3][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]");
		
		
		ServicioCalendario servicio = new ServicioCalendario();
		
		fecha=servicio.calendarioToString(cal);
		assert(fecha!=null):"DEBERIA DEVOLVER UN STRING";
		
		Matcher m = p.matcher(fecha);
		assert(m.matches()):"El formato de fecha deberia ser el indicado";
	}
	
	@Test
	public void stringToCalendario() throws FechaNoValidaException{
		Calendar cal = Calendar.getInstance();
		String fecha1="01/12/2009";
		ServicioCalendario servicio = new ServicioCalendario();
		Pattern p = Pattern.compile("[0-3][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]");
		
		try{
			cal=servicio.stringToCalendario(fecha1);
			assert(cal!=null):"deberia devolver un calendario";
			
			Integer date = cal.get(Calendar.DATE);
			assert(date.equals(1)):"el dia no corresponde";
			
			Integer month = cal.get(Calendar.MONTH);
			assert(month.equals(11)):"el mes no corresponde";
			
			Integer year = cal.get(Calendar.YEAR);
			assert(year.equals(2009)):"el a–o no corresponde";
			
			
		}
		catch (FechaNoValidaException e) {
			System.out.println(e.getMessage());
		}
		
		Matcher m = p.matcher(servicio.calendarioToString(cal));
		assert(m.matches()):"deberia cumplir el formato";
		
		try{
			cal=servicio.stringToCalendario(fecha1);
			assert(servicio.calendarioToString(cal).equals(fecha1)):"debe ser igual a fecha";
		}
		catch (FechaNoValidaException e){
			System.out.println(e.getMessage());
		}
		
		
		
	}
	@Test
	public void comprobarIntervalo(){
		Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		Integer intervalo=5;
		cal2.roll(Calendar.DATE, intervalo);
		ServicioCalendario servicio = new ServicioCalendario();
		
		Integer inter = servicio.getIntervaloFecha(cal1,cal2);
		assert(inter.equals(intervalo)):"debe ser igual a intervalo";
	}

}
