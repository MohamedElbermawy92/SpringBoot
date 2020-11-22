package springboot.starter.errorHandler;

import org.springframework.http.HttpStatus;

public class NotFounException extends APIexception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NotFounException(String message) {
		super(message);
		
	}



	@Override
	protected HttpStatus getHttpStatus() {
		
		return HttpStatus.NOT_FOUND;
	}

}
