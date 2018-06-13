/**
 * Interfaz de Servicios de Usuarios de la Aplicación Elecc
 */
package com.elecc.service;

import java.io.Serializable;

/**
 * @author Ramón Cigüenza
 *
 */
public interface UserService extends Serializable {

	// Servicio de autenticación de usuarios, devolverá el tipo de privilegio:
	// usuario corriente o administrador
	public int authUser(String identification, String pass);
	
	// Servicio que modifica el privilegio de un usuario en la aplicación
	// Esta acción sólo la podrán llevar a cabo los administradores
	public void updatePrivilege(String identOwner,String identCitizen, int newPrivilege );
	
}
