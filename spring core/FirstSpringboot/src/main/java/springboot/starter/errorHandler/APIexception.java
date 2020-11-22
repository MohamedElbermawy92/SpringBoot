package springboot.starter.errorHandler;

import org.springframework.http.HttpStatus;

public abstract class APIexception extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public APIexception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	protected abstract HttpStatus getHttpStatus();
		
	
	
}
