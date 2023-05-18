package com.akihito.cursoSpring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akihito.cursoSpring.exceptions.UnsupportedMathOperationException;

@RestController

public class MathController {
		
	//definir qual a rota que esse controller irá responder, usando o RequestMapping()
	//definir tambem qual o tipo da requição o metodo será responsavel por responder
	//temos que pegar os valores do request, usamos para isso o @PathVariable e depois
	//vamos atribuir o valor do request a String numberOne, fazeremos isso para o numberTwo
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception 
	 {
		
			
			if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
				
		
			} 
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
		
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable(value = "numberOne")String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		Double numberOneConverted = convertToDouble(numberOne);
		Double numberTwoConverted = convertToDouble(numberTwo);
		Double Result = numberOneConverted - numberTwoConverted;
		
		return Result;
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception  {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
		
	}
	
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}/{numberThree}/{numberFour}"
			, method = RequestMethod.GET)
	public Double average(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo, @PathVariable(value =
			"numberThree") String numberThree, @PathVariable(value = "numberFour") 
	         String numberFour) {
		      
	       if(!isNumeric(numberOne) || !isNumeric(numberTwo) || !isNumeric(numberThree) || !isNumeric(numberFour)) {
	    	   throw new UnsupportedMathOperationException("Please set a numeric value");
	       }
	       
	       Double one = convertToDouble(numberOne);
	       Double two = Double.parseDouble(numberTwo);
	       Double three = convertToDouble(numberThree);
	       Double four = Double.parseDouble(numberFour);
	       
	       Double result = (one + two + three + four) / 4;
		
		    return result;
	}
	
	
	@RequestMapping(value = "/squareRoot/{number}")
	public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {
		if(!isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		
		Double num = Math.sqrt(convertToDouble(number));
		
		return num;
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
