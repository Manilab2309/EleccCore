/**
 * 
 */
package com.elecc.repository;

import java.io.Serializable;

import com.elecc.exceptions.EleccUserNotAuthorizedException;
import com.elecc.security.repository.JWTUser;

/**
 * @author Ramón Cigüenza
 *
 */
public interface CitizenDao extends Serializable {

	// Registrar nuevo ciudadano
	public void registerCitizen(String name, String surname, String identification, String pass, String province, int privileges, String photoURL);

	// Dar de baja ciudadano
	public void removeCitizen(String identification, String province);

	// Votar
	public void voteParty(String party);
	
	// Autenticación del usuario
	public JWTUser authUser(String identification, String pass) throws EleccUserNotAuthorizedException;
		
	// Cambio de privilegios al usuario
	public void updatePrivilege(String identOwner, String identCitizen, int newPrivilege);
		
}
