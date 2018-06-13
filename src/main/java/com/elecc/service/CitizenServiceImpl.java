/**
 * 
 */
package com.elecc.service;

import org.springframework.stereotype.Service;

/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "citizenService")
public class CitizenServiceImpl implements CitizenService {

	private static final long serialVersionUID = 1L;

	public void registerCitizen(String name, String surname, String identification, String pass,
			String province, int privileges, String photoURL) {
		// TODO Auto-generated method stub
		
	}


	public void removeCitizen(String identification, String province) {
		// TODO Auto-generated method stub
		
	}


	public void voteParty(String party) {
		// TODO Auto-generated method stub
		
	}
	
	

}
