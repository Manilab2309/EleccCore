/**
 * Implementación de Servicios para gestión de usuarios de la aplicación
 */
package com.elecc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elecc.exceptions.UserNotAuthorizedException;
import com.elecc.repository.CitizenDao;

/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private CitizenDao citizenRepositoryDao;
	
	public void authUser(String identification, String pass) throws UserNotAuthorizedException {
		citizenRepositoryDao.authUser(identification, pass);
	}

	public void updatePrivilege(String identOwner, String identCitizen, int newPrivilege) {
		// TODO Auto-generated method stub
		
	}
	
	

}
