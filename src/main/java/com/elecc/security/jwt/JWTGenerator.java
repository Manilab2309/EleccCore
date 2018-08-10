/**
 * 
 */
package com.elecc.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elecc.controller.UserController;
import com.elecc.security.repository.JWTUser;
import com.elecc.service.UserServiceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Ramón Cigüenza Fuster
 *
 */

@Component
public class JWTGenerator {

	/** key JWT */
	private static final String keyJWT = "JelecWcKeyT";
	
	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	public String generate(JWTUser jwtUser) {

			
		// TODO: Se debe calcular el nombre del usuario en MONGODB
        Claims claims = Jwts.claims()
                .setSubject("NAME_MONGO");
        claims.put("ident", String.valueOf(jwtUser.getIdent()));
 
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, keyJWT)
                .compact();
    }
	
}
