/**
 * 
 */
package com.elecc.security.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Ramón Cigüenza Fuster
 *
 */
public class JWTUserDetails implements UserDetails {

	/**
	 * Serial ID Object
	 */
	private static final long serialVersionUID = 4748666493880482143L;
	
	private String userName;
	private String dni;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;


    public JWTUserDetails(String userName, String dni, String token, List<GrantedAuthority> grantedAuthorities) {

    	this.userName=userName;
        this.dni = dni;
        this.token= token;
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return "Not Allowed";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getDni() {
        return dni;
    }

    public String getToken() {
        return token;
    }

	public String getUsername() {
		return userName;
	}

}
