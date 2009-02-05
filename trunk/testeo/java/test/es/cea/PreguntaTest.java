package es.cea;

import org.testng.annotations.Test;

public class PreguntaTest {
	@Test
	public void referenciaExamenNumero(){
		Examen examen1=new Examen("ref1");
		Examen examen2=new Examen("ref2");
		Examen examen1Bis=new Examen("ref1");
		
		Pregunta pregunta1=new Pregunta(examen1,1);
		Pregunta pregunta2=new Pregunta(examen2,2);
		Pregunta pregunta3=new Pregunta(examen1,2);
		Pregunta pregunta1Bis=new Pregunta(examen1,1);
		
		boolean equals1=examen1.equals(examen2);
		assert(!equals1):"examen 1 debe ser distinto a 2";
		
		boolean equals2=examen1.equals(examen1Bis);
		assert(equals2):"examen 1 debe ser igual a examen1bis";
		
		boolean equals3=pregunta1.equals(pregunta2);
		assert(!equals3):"pregunta 1 debe ser distinta a la 2";
		
		boolean equals4=pregunta1.equals(pregunta3);
		assert(!equals4):"pregunta 1 debe ser distinta a 3 ya que el numero de preguntas es distinto";
		
		boolean equals5=pregunta1.equals(pregunta1Bis);
		assert(equals5):"pregunta 1 debe ser igual a pregunta1bis";
	}
}
