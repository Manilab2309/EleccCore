/**
 * 
 */
package com.elecc.security.repository;

/**
 * @author Ramón Cigüenza Fuster
 *
 */
public class JWTUser {

	private String userName;
	private String dni;
    private String role;

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDni() {
        return dni;
    }

    public String getRole() {
        return role;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
