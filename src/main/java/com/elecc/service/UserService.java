/**
 * Interfaz de Servicios de Usuarios de la Aplicación Elecc
 */
package com.elecc.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.elecc.exceptions.EleccUserNotAuthorizedException;
import com.elecc.security.repository.JWTUser;

/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "userService")
public interface UserService extends Serializable {

	// Servicio de autenticación de usuarios, devolverá el tipo de privilegio:
	// usuario corriente o administrador
	public JWTUser authUser(String identification, String pass) throws EleccUserNotAuthorizedException;
	
	// Servicio que modifica el privilegio de un usuario en la aplicación
	// Esta acción sólo la podrán llevar a cabo los administradores
	public void updatePrivilege(String identOwner,String identCitizen, int newPrivilege );
	
}
