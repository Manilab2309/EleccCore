/**
 * Ciudadano
 */
package com.elecc.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ramón Cigüenza
 *
 *         Al ser una BBDD no relacional no se precisa distinguir entre
 *         ciudadanos, usuarios de la aplicación y candidatos, todos son
 *         personas con más o menos campos. Tampoco se precisa indicar la comunidad ya que en la
 *         escalabilidad de la BBDD cada provincia tendra su tabla citizen con sus cliudadanos.
 */

@Document(collection = "citizen")
public class Citizen implements Serializable {

	/**
	 * Default serializable object ID
	 */
	private static final long serialVersionUID = 1L;

	private String idUser;
	private String name;
	private String surname;
	private String identification;
	private String pass;
	private String province;
	
	// Un usuario puede ser sin priviligios, sólo podrá votar 0, o administrador 1, podrá votar y consultar escrutinio.
	private int privileges;
	
	// Un candidato tendrá foto publicada, un ciudadano normal no.
	private String photoURL;

	public int getPrivileges() {
		return privileges;
	}

	public void setPrivileges(int privileges) {
		this.privileges = privileges;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

}
