/**
 * 
 */
package com.elecc.security.jwt;

import org.springframework.stereotype.Component;

import com.elecc.security.repository.JWTUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Administrador
 *
 */

@Component
public class JWTGenerator {

	public String generate(JWTUser jwtUser) {


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("dni", String.valueOf(jwtUser.getDni()));
        claims.put("role", jwtUser.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
	
}
