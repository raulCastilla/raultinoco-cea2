package es.cea;

import org.testng.annotations.Test;

public class LocalizacionTest {
	@Test
	public void localizacionIdentidad(){
		Localizacion local1 = new Localizacion("ref1",1);
		Localizacion local2 = new Localizacion("ref2",2);
		Localizacion local3 = new Localizacion("ref2",1);
		Localizacion local1Bis = new Localizacion("ref1",1);
		
		assert(!local1.equals(local2)):"deben ser distintos";
		assert(!local2.equals(local3)):"deben ser distintos";
		assert(local1.equals(local1Bis)):"deben ser iguales";
	}
}
