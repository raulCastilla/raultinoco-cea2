package es.cea;

import org.testng.annotations.Test;

public class AulaTest {
	@Test
	public void localizacionIdentidad(){
		Localizacion local1=new Localizacion("ref1",1);
		Localizacion local2=new Localizacion("ref2",2);
		Localizacion local1Bis=new Localizacion("ref1",1);
		
		Aula aula1 = new Aula(local1,"aula1");
		Aula aula2 = new Aula(local2,"aula2");
		Aula aula1Bis = new Aula(local1,"aula1Bis");
		
		assert(!aula1.equals(aula2)):"Aula 1 debe ser distinta a 2";
		assert(aula1.equals(aula1Bis)):"Aula 1 debe ser igual a aula1bis";
		
	}
}
