/**
 * Implementación de Servicios para gestión de usuarios de la aplicación
 */
package com.elecc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elecc.exceptions.EleccUserNotAuthorizedException;
import com.elecc.repository.CitizenDao;
import com.elecc.security.repository.JWTUser;

/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	/**
	 * Serial ID Object
	 */
	private static final long serialVersionUID = 3159512606854079070L;
	
	@Autowired
	private CitizenDao citizenRepositoryDao;
	
	public JWTUser authUser(String identification, String pass) throws EleccUserNotAuthorizedException {
		return citizenRepositoryDao.authUser(identification, pass);
	}

	public void updatePrivilege(String identOwner, String identCitizen, int newPrivilege) {
		// TODO Auto-generated method stub
		
	}
	
	

}
