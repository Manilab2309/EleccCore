/**
 * 
 */
package com.elecc.config;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.elecc.application.EleccCoreApplication;

/**
 * @author Administrador
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(EleccCoreApplication.class);
	
	private static String userAPIAllowed = "admin2";
	private static String passAPIAllowed = "admin2";
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		logger.debug("[EleccCore] - Validando credenciales Springboot Security");
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		if (name.equalsIgnoreCase(userAPIAllowed) && name.equalsIgnoreCase(passAPIAllowed))
			return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
		else {
			throw new BadCredentialsException("[EleccAPISecurity] - Credentials error");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
