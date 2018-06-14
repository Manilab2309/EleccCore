/**
 * Implementación de Acceso a BBDD NoSQL para los servicios de los ciudadanos
 */
package com.elecc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.elecc.entity.Citizen;

/**
 * @author Ramón Cigüenza
 *
 */

@Repository
@Qualifier("citizenDao")
public class MDBCitizenDaoImpl implements CitizenDao {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	MongoTemplate mongoTemplate;

	// Implementación de la autenticación del usuario
	public int authUser(String identification, String pass) {
		
		int result=-1;
		
		Query query = new Query();
		query.addCriteria(Criteria.where("ident").is(identification));
		Citizen citizen = mongoTemplate.findOne(query,Citizen.class);	
		
		if(citizen.getPass().equals(pass)){
			return citizen.getPrivileges();
		}
		
		return result;
	}

	public void updatePrivilege(String identOwner, String identCitizen, int newPrivilege) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerCitizen(String name, String surname, String identification, String pass, String province,
			int privileges, String photoURL) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCitizen(String identification, String province) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voteParty(String party) {
		// TODO Auto-generated method stub
		
	}
	
}
