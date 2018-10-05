/**
 * Interfaz de Servicios para mantenimiento de Partidos Políticos
 */
package com.elecc.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.elecc.entity.Citizen;
import com.elecc.entity.PoliticGroup;



/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "politicGroupService")
public interface PoliticGroupService extends Serializable {
	
	// Consultar todos los partidos políticos
	public List<PoliticGroup> getPoliticGroups();
	
	// Registrar nuevo partido político
	public void registerPoliticalParty(String name,	String urlOfficialWeb,	String urlLogo,	List<Citizen> members, long votes);

	// Dar de baja un partido político
	public void removePoliticalParty(String identification, String province);
	
	

}
