package es.cea;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class ServicioCalendarioTest {
	
	@Test
	public void calendarioToString(){
//		Escenario de pruebas
		Calendar cal = Calendar.getInstance();
		String fecha;
		Pattern p = Pattern.compile("[0-3][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]");
		
		
		ServicioCalendario servicio = new ServicioCalendario();
		
//		calendarioToString() debe devolver un String
		fecha=servicio.calendarioToString(cal);
		assert(fecha!=null):"DEBERIA DEVOLVER UN STRING";
		System.out.println("En este caso la fecha es: "+fecha);
//		System.out.println(fecha);
		Matcher m = p.matcher(fecha);
		assert(m.matches()):"El formato de fecha deberia ser el indicado";
	}
	
	@Test
	public void stringToCalendario(){
		Calendar cal = Calendar.getInstance();
		String fecha="1/12/2009";
		ServicioCalendario servicio = new ServicioCalendario();
		Pattern p = Pattern.compile("[0-3][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]");
		
		try{
		cal=servicio.stringToCalendario(fecha);
		assert(cal!=null):"deberia devolver un calendario";
		}
		catch (FechaNoValidaException e) {
			System.out.println(e.getMessage());
		}
		
		Matcher m = p.matcher(servicio.calendarioToString(cal));
		assert(m.matches()):"deberia cumplir el formato";
		
		try{
			cal=servicio.stringToCalendario(fecha);
			System.out.println("La fecha devuelta es: "+servicio.calendarioToString(cal));
//			assert(servicio.calendarioToString(cal).equals(fecha)):"debe ser igual a fecha";
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
		
		Integer inter = servicio.getIntervalo(cal1,cal2);
		assert(inter.equals(intervalo)):"debe ser igual a intervalo";
	}

}
