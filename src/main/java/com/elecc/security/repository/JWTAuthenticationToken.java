/**
 * 
 */
package com.elecc.security.repository;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author Ramón Cigüenza Fuster
 *
 */
public class JWTAuthenticationToken extends UsernamePasswordAuthenticationToken {

	/**
	 * Serial ID Object
	 */
	private static final long serialVersionUID = -2947225733263324665L;
	
	private String token;

    public JWTAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
