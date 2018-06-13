/**
 * Interfaz de Servicios de Escrutinio en las Elecciones Generales
 */
package com.elecc.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

/**
 * @author Ramón Cigüenza
 *
 */

@Service(value = "electionsService")
public interface ElectionsService extends Serializable {

	// Servicio de consulta de escrutinio, como parámetro recibirá el nombre de
	// una provincia a la que consultar, si se pasa vacío calculará el escrutinio nacional
	public float getPoll(String scope);

	
}
