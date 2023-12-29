package projeto.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projeto.exception.UnsuportMathOperationExeption;

@RestController
public class MathController {
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET )
	
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsuportMathOperationExeption("por favor informe um valor numerico");
		}
		
		return converterToDouble(numberOne) + converterToDouble(numberTwo);
		
	}
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportMathOperationExeption("por favor informe um valor numerico");
		}
		return converterToDouble(numberOne) - converterToDouble(numberTwo);
	}
	@RequestMapping(value = "/multi/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double multi(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportMathOperationExeption("por favor informe um valor numerico");
		}
		return converterToDouble(numberOne) * converterToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double div(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportMathOperationExeption("por favor informe um valor numerico");
		}
		return converterToDouble(numberOne) / converterToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/med/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double med(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportMathOperationExeption("por favor informe um valor numerico");
		}
		return (converterToDouble(numberOne) + converterToDouble(numberTwo))/2;
	}
	@RequestMapping(value = "/raiz/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public String raiz(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportMathOperationExeption("por favor informe um valor numerico");
		}
			String total = "raiz de "+converterToDouble(numberOne)+" é: "+Math.sqrt(converterToDouble(numberOne));
			total += "  raiz de "+converterToDouble(numberTwo)+" é: "+Math.sqrt(converterToDouble(numberTwo));
		return total;
	}

	private Double converterToDouble(String number) {
		if(number == null) {
			return 0D;
			
		}
		
		String numero = number.replaceAll(",", ".");
		
		if(isNumeric(numero)) {
			return Double.valueOf(numero);
		}
		
		return 0D;
		
	}

	private boolean isNumeric(String number) {
		if(number == null) {
			return false;
			
		}
		String numero = number.replaceAll(",", ".");
		return numero.matches("[-+]?[0-9]*\\.?[0-9]+");
		
	}

}
