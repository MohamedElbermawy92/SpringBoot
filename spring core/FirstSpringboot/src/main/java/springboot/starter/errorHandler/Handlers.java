package springboot.starter.errorHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Handlers extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(APIexception.class)
	public ResponseEntity<ErrorDetails> handleNotFounException(APIexception ex , WebRequest request){
		
		ErrorDetails error = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error  , ex.getHttpStatus());
	}
}
