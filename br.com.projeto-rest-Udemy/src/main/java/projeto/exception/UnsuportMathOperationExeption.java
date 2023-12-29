package projeto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportMathOperationExeption extends RuntimeException{
    
	public UnsuportMathOperationExeption(String Mensagem) {
		super(Mensagem);
	}
	
	private static final long serialVersionUID = 1L;

}
