package es.cea;

import org.testng.annotations.Test;

public class ComprobarFechaTest {
	
	@Test
	public void comprobarFormatoFecha(){
		ComprobarFecha comFech = new ComprobarFecha();
		String fecha1 = "01/03/1981";
		String fecha2 = "65/23/1990";
		String fecha3 = "02/06/09";
		
		Boolean equals1 = comFech.comprobarFormatoFecha(fecha1);
		assert(equals1):"deberia ser verdadero";
		
		Boolean equals2 = comFech.comprobarFormatoFecha(fecha2);
		assert(!equals2):"debe ser falso";
		
		Boolean equals3 = comFech.comprobarFormatoFecha(fecha3);
		assert(!equals3):"deberia ser falso";
	}

}
