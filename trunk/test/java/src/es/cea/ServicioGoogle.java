package es.cea;

public class ServicioGoogle {
	public Boolean conecta(String usuario,String password) throws ParametroNuloException{
		if(usuario==null) throw new ParametroNuloException();
		if(usuario.equals("cea")&&password.equals("cea"))
			return true;
		
		
		if(usuario.equals("admin")&&password.equals("admin"))
			return true;
		return false;
	}
}
