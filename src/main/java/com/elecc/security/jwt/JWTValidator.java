/**
 * 
 */
package com.elecc.security.jwt;

import org.springframework.stereotype.Component;

import com.elecc.security.repository.JWTUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author Ramón Cigüenza Fuster
 *
 */

@Component
public class JWTValidator {
	
	private String secret = "JelecWcKeyT";

    public JWTUser validate(String token) {

        JWTUser jwtUser = null;
        
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JWTUser();

            jwtUser.setIdent(body.getSubject());
            jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }

}
