package es.cea.tienda;

import javax.servlet.http.HttpServletRequest;

public class Utilidades {
	 public static String obtenerURLActual(HttpServletRequest httpRequest) {
         
         String peticionActualDeUsuario=httpRequest.getRequestURI().replace("/tienda", "")+"?"+httpRequest.getQueryString();
         System.out.println("petition actual con parametros:"+peticionActualDeUsuario);

         return peticionActualDeUsuario;
	 }

}
