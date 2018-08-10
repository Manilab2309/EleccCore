/**
 * 
 */
package com.elecc.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.elecc.controller.UserController;
import com.elecc.util.Constants;

/**
 * @author Ramón Cigüenza Fuster
 *
 */
public class JWTSuccessHandler implements AuthenticationSuccessHandler {
	
	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.debug(Constants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG + "JWT Successfully Authentication");
    }

}
