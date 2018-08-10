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

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal Security Error")  // 500
public class EleccSecurityException extends RuntimeException{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 8164994903915232511L;
	
	/**
	 * Default Message Exception
	 */
	private static final String DEFAULT_MESSAGE_ERROR = "Encrypt Module Error";

	public EleccSecurityException() {
		super(DEFAULT_MESSAGE_ERROR);
    }

    public EleccSecurityException(String message) {
        super(message);
        
    }

    public EleccSecurityException(Throwable cause) {
        super(cause);
        
    }

    public EleccSecurityException(String message, Throwable cause) {
        super(message, cause);
        
    }
	
	
}
