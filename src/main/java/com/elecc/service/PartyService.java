/**
 * Interfaz de Servicios para mantenimiento de Partidos Políticos
 */
package com.elecc.service;

import java.io.Serializable;
import java.util.List;

import com.elecc.entity.Citizen;

/**
 * @author Ramón Cigüenza
 *
 */
public interface PartyService extends Serializable {
	
	// Registrar nuevo partido político
	public void registerPoliticalParty(String name,	String urlOfficialWeb,	String urlLogo,	List<Citizen> members, long votes);

	// Dar de baja un partido político
	public void removePoliticalParty(String identification, String province);

}
