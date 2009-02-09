package es.cea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bean {
	
	List<String> valor1=new ArrayList<String>();
	
	Map<String, String> valor2=new HashMap<String, String>();

	public List<String> getValor1() {
		return valor1;
	}

	public void setValor1(List<String> valor1) {
		this.valor1 = valor1;
	}

	public Map<String, String> getValor2() {
		return valor2;
	}

	public void setValor2(Map<String, String> valor2) {
		this.valor2 = valor2;
	} 

}
