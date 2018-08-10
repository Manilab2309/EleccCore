/**
 * 
 */
package com.elecc.security.repository;

/**
 * @author Ramón Cigüenza Fuster
 *
 */
public class JWTUser {

	private String ident;
	private String sign;
	private String role;
	private String name;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getIdent() {
        return ident;
    }
    
    public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return sign;
	}
}
