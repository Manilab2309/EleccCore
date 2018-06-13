/**
 * Implementación de Servicios para mantenimiento de partidos políticos
 */
package com.elecc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elecc.entity.Citizen;

/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "partyService")
public class PartyServiceImpl implements PartyService {

	private static final long serialVersionUID = 1L;

	public void registerPoliticalParty(String name, String urlOfficialWeb, String urlLogo, List<Citizen> members,
			long votes) {
		// TODO Auto-generated method stub
		
	}

	public void removePoliticalParty(String identification, String province) {
		// TODO Auto-generated method stub
		
	}
	
}
