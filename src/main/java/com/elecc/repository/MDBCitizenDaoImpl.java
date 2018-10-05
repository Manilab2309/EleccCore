/**
 * Implementación de Acceso a BBDD NoSQL para los servicios de los ciudadanos
 */
package com.elecc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.elecc.entity.Citizen;
import com.elecc.exceptions.EleccUserNotAuthorizedException;
import com.elecc.security.crypto.DataEncrypter;
import com.elecc.security.repository.JWTUser;
import com.elecc.util.Constants;

/**
 * @author Ramón Cigüenza
 *
 */

@Repository
@Qualifier("citizenDao")
public class MDBCitizenDaoImpl implements CitizenDao {

	/**
	 * Serial ID Object
	 */
	private static final long serialVersionUID = -1194318132326816585L;

	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(MDBCitizenDaoImpl.class);
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	DataEncrypter cipher = new DataEncrypter();

	// Implementación de la autenticación del usuario
	public JWTUser authUser(String identification, String pass) throws EleccUserNotAuthorizedException {

		JWTUser userSecure = new JWTUser();

		Query query = new Query();
		query.addCriteria(Criteria.where(Constants.ModelFields.FIELD_CTZ_IDENTIFICATION).is(identification));
		Citizen citizen = mongoTemplate.findOne(query, Citizen.class);

		if (cipher.extractSalt(cipher.decrypt(citizen.getPass())).equals(cipher.extractSalt(cipher.decrypt(pass)))) {
			
			logger.debug(Constants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
					+ "Checking credentials for user access...");
			
			/** Successful authentication */
			userSecure.setName(citizen.getName() + Constants.SPACE + citizen.getSurname());
			userSecure.setIdent(citizen.getIdUser());
			userSecure.setSign(Constants.EMPTY);

			if (citizen.getPrivileges() == 1)
				userSecure.setRole(Constants.ADMIN);
			else
				userSecure.setRole(Constants.NORMAL);

			return userSecure;
			
		} else {
			
			/** Bad credentials */
			logger.debug(Constants.MsgDebugOperations.DEBUG_PREFIX_MSG_DEBUG
					+ "User credentials invalid");
			throw new EleccUserNotAuthorizedException(Constants.MsgExceptions.MSG_ERROR_USER_NOT_AUTHORIZED);
		
		}

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
