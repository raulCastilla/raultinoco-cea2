package es.cea;

import org.testng.annotations.Test;

public class ServicioGoogleTest {
	@Test
	public void conecta() throws ParametroNuloException{
		ServicioGoogle servicio =  new ServicioGoogle();
		servicio.conecta("admin", "admin");
		Boolean estado=servicio.conecta("admin","admin");
		assert(estado):"Se esperaba conectar con el parametro admin";
		
		Boolean estado2=servicio.conecta("cea", "cea");
		assert(estado2==true);
		
		try{
			servicio.conecta(null, "");
			assert(false):"no se ha lanzado el error";
		}catch(ParametroNuloException e){
			assert(true);
		} 
	}
}
