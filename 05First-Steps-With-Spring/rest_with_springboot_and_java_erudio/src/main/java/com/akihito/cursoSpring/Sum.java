package com.akihito.cursoSpring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Sum {
		
	//definir qual a rota que esse controller irá responder, usando o RequestMapping()
	//definir tambem qual o tipo da requição o metodo será responsavel por responder
	//temos que pegar os valores do request, usamos para isso o @PathVariable e depois
	//vamos atribuir o valor do request a String numberOne, fazeremos isso para o numberTwo
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception 
	 {
		
			
			if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
				throw new Exception("Tipo de dado inconpatível, favor informar apenas números");
				
		
			} 
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
		
	}
	
	private double convertToDouble(String strNumber) {
		
		if(strNumber == null) return 0D;
		
		String number = strNumber.replaceAll("," , ".");
		
		
		if(isNumeric(number)) {
			
			return Double.parseDouble(number);
			
		}
		
		return 0D;
		
	}

	private boolean isNumeric(String strNumber) {
		
		if(strNumber == null) return false;
		
		String number = strNumber.replaceAll("," , ".");
		
		return number.matches("-?\\d+(\\.\\d+)?");
	}
	
}
