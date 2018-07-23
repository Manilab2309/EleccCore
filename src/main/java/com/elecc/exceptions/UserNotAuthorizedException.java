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

@ResponseStatus(value=HttpStatus.UNAUTHORIZED, reason="User Not Authorized")  // 404
public class UserNotAuthorizedException extends Exception{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 8164994903915232511L;
	
	/**
	 * Default Message Exception
	 */
	private static final String DEFAULT_MESSAGE_ERROR = "User Not Authorized";

	public UserNotAuthorizedException() {
		super(DEFAULT_MESSAGE_ERROR);
    }

    public UserNotAuthorizedException(String message) {
        super(message);
        
    }

    public UserNotAuthorizedException(Throwable cause) {
        super(cause);
        
    }

    public UserNotAuthorizedException(String message, Throwable cause) {
        super(message, cause);
        
    }
	
	
}
