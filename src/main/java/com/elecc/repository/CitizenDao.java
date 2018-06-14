/**
 * 
 */
package com.elecc.repository;

import java.io.Serializable;

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
	public int authUser(String identification, String pass);
		
	// Cambio de privilegios al usuario
	public void updatePrivilege(String identOwner, String identCitizen, int newPrivilege);
		
}
