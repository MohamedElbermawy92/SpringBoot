package springboot.starter.errorHandler;

import org.springframework.http.HttpStatus;

public class ConflictException extends APIexception {

	
	public ConflictException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected HttpStatus getHttpStatus() {
		
		return HttpStatus.CONFLICT;
	}

}
