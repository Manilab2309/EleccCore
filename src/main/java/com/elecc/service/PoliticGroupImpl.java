/**
 * Implementación de Servicios para mantenimiento de partidos políticos
 */
package com.elecc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elecc.entity.Citizen;
import com.elecc.entity.PoliticGroup;
import com.elecc.repository.PoliticGroupDao;

/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "partyService")
public class PoliticGroupImpl implements PoliticGroupService {

	/**
	 * Serial ID Object
	 */
	private static final long serialVersionUID = -2770527690930326957L;
	
	@Autowired
	private PoliticGroupDao politicGroupDao;

	public void registerPoliticalParty(String name, String urlOfficialWeb, String urlLogo, List<Citizen> members,
			long votes) {
		// TODO Auto-generated method stub
		
	}

	public void removePoliticalParty(String identification, String province) {
		// TODO Auto-generated method stub
		
	}

	public List<PoliticGroup> getPoliticGroups() {
		return politicGroupDao.getPoliticGroups();
	}
	
}
