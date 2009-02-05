package es.cea;

import org.testng.annotations.Test;

public class ExamenTest {
	
	@Test
	public void referenciaIdentidad(){
//		Escenario de prueba
		Examen examen1 = new Examen("ref1");
		Examen examen2 = new Examen("ref2");
		Examen examen3 = new Examen("ref3");
		Examen examen1Bis = new Examen("ref1");
//		Invocacion 1
		boolean equals1 = examen1.equals(examen3);
//		confirmacion 1
		assert(!equals1):"el examen 1 debe ser diferente del tres";
//		Invocacion 2
		boolean equals2 = examen1.equals(examen1Bis);
//		confirmacion 2
		assert(equals2):"el examen bis debe ser igual al 1";
	}
}
