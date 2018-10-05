/**
 * Implementación de Servicios para mantenimiento de partidos políticos
 */
package com.elecc.service;

import org.springframework.stereotype.Service;

import com.elecc.service.ElectionsService;
/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "electionsService")
public class ElectionsServiceImpl implements ElectionsService {

	
	/**
	 * Serial ID Object
	 */
	private static final long serialVersionUID = 1477202157025174306L;
	

	public float getPoll(String scope) {
		// TODO Auto-generated method stub
		return 0;
	}

}
