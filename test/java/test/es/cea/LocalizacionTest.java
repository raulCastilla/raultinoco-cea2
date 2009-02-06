package es.cea;

import org.testng.annotations.Test;

public class LocalizacionTest {
	@Test
	public void localizacionIdentidad(){
		Localizacion local1 = new Localizacion("ref1",1);
		Localizacion local2 = new Localizacion("ref2",2);
		Localizacion local3 = new Localizacion("ref2",1);
		Localizacion local1Bis = new Localizacion("ref1",1);
		
		boolean equals1=local1.equals(local2);
		assert(!equals1):"deben ser distintos";
		
		
		boolean equals2=local2.equals(local3);
		assert(!equals2):"deben ser distintos";
		
		boolean equals3=local1.equals(local1Bis);
		assert(equals3):"deben ser iguales";
	}
}
