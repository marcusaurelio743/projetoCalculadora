package projeto.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET )
	
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			)throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new Exception();
		}
		
		return converterToDouble(numberOne) + converterToDouble(numberTwo);
		
	}

	private Double converterToDouble(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean isNumeric(String number) {
		// TODO Auto-generated method stub
		return false;
	}

}
