/**
 * 
 */
package com.elecc.repository;

import java.util.List;

import com.elecc.entity.PoliticGroup;

/**
 * @author Ramón Cigüenza
 *
 */
public interface PoliticGroupDao {

	// Consulta de todos los partidos políticos
	public List<PoliticGroup> getPoliticGroups();
}
