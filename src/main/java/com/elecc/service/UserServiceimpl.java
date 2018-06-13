/**
 * Implementación de Servicios para gestión de usuarios de la aplicación
 */
package com.elecc.service;

import org.springframework.stereotype.Service;

/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "userService")
public class UserServiceimpl implements UserService {
	
	private static final long serialVersionUID = 1L;

	public int authUser(String identification, String pass) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void updatePrivilege(String identOwner, String identCitizen, int newPrivilege) {
		// TODO Auto-generated method stub
		
	}
	
	

}
