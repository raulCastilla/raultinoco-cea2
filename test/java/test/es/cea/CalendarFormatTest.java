package es.cea;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

public class CalendarFormatTest {

	
	@Test
	public void prueba(){
		
		Calendar ahora = Calendar.getInstance();
		SimpleDateFormat formater=new SimpleDateFormat();
		formater.applyPattern("dd/MM/yy");
		System.out.println("formateando:::: "+formater.format(ahora.getTime()));
		
		
		
	}
	
	
	
}
