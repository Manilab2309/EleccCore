/**
 * Interfaz de Servicios para mantenimiento de Ciudadanos
 */
package com.elecc.service;

import java.io.Serializable;

/**
 * @author Ramón Cigüenza
 *
 */
public interface CitizenService extends Serializable {

	// Registrar nuevo ciudadano
	public void registerCitizen(String name, String surname, String identification, String pass, String province, int privileges, String photoURL);

	// Dar de baja ciudadano
	public void removeCitizen(String identification, String province);

	// Votar
	public void voteParty(String party);

}
