/**
 * 
 */
package com.elecc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ramón Cigüenza
 *
 */

@ResponseStatus(value=HttpStatus.NO_CONTENT, reason="Not Available Data")  // 204
public class EleccNoDataException extends RuntimeException {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 8164994903915232511L;
	
	/**
	 * Default Message Exception
	 */
	private static final String DEFAULT_MESSAGE_ERROR = "Not Found Data Content";

	public EleccNoDataException() {
		super(DEFAULT_MESSAGE_ERROR);
    }

    public EleccNoDataException(String message) {
        super(message);
        
    }

    public EleccNoDataException(Throwable cause) {
        super(cause);
        
    }

    public EleccNoDataException(String message, Throwable cause) {
        super(message, cause);
        
    }
}
