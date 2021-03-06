/**
 * 
 */
package com.elecc.security.authentication;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.elecc.application.EleccCoreApplication;
import com.elecc.exceptions.EleccSecurityException;
import com.elecc.security.crypto.DataEncrypter;
import com.elecc.util.Constants;

/**
 * @author Ramón Cigüenza Fuster
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(EleccCoreApplication.class);

	/** Valid Credentials for Springboot Security */
	private static String userAPIAllowed = "admin2";
	private static String passAPIAllowed = "oD5TsOGzkZT3dnKuQ/a4PA==";

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		try {
			logger.debug(Constants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
					+ "Checking credentials for Springboot Security...");

			String name = authentication.getName();
			String pass = authentication.getCredentials().toString();

			DataEncrypter dataCipher = new DataEncrypter();
			String passClientDecrypted = dataCipher.extractSalt(dataCipher.decrypt(pass));
			String passAPIServerDecrypted = dataCipher.extractSalt(dataCipher.decrypt(passAPIAllowed));

			if (name.equalsIgnoreCase(userAPIAllowed) && passClientDecrypted.equalsIgnoreCase(passAPIServerDecrypted)) {
				logger.debug(Constants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
						+ "Login successfully, retrieving API services...");

				Authentication authResult = new UsernamePasswordAuthenticationToken(name, pass, new ArrayList<>());
				SecurityContextHolder.getContext().setAuthentication(authResult);
				return authResult;
			} else {
				throw new BadCredentialsException(Constants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
						+ Constants.MsgExceptions.MSG_ERROR_BAD_CREDENTIALS);
			}
		} catch (EleccSecurityException e) {
			logger.debug(Constants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
					+ "Error in encrypting module");			
				throw new EleccSecurityException(Constants.MsgExceptions.MSG_ERROR_ENCRYPT_MODULE, e);
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
