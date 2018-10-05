/**
 * 
 */
package com.elecc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.elecc.entity.Citizen;
import com.elecc.entity.PoliticGroup;
import com.elecc.util.Constants;

/**
 * @author Ramón Cigüenza
 *
 */

@Repository
@Qualifier("politicGroupDao")
public class MDBPoliticGroupDaoImpl implements PoliticGroupDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<PoliticGroup> getPoliticGroups() {
		
		Query query = new Query();
		
		List<PoliticGroup> politicGroupList = mongoTemplate.find(query, PoliticGroup.class);
		
		return politicGroupList;
	}

}
