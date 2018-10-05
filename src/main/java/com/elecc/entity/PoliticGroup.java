/**
 * Partido Político
 */
package com.elecc.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ramón Cigüenza
 * 
 * 		Los partidos políticos contemplan como campo una lista de ciudadanos candidatos
 *
 */

@Document(collection = "partidos")
public class PoliticGroup implements Serializable {

	/**
	 * Serial ID Object
	 */
	private static final long serialVersionUID = -3050881464509458368L;
	
	private String name;
	private String urlOfficialWeb;
	private String urlLogo;
	private List<Citizen> members;
	private long votes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrlOfficialWeb() {
		return urlOfficialWeb;
	}
	public void setUrlOfficialWeb(String urlOfficialWeb) {
		this.urlOfficialWeb = urlOfficialWeb;
	}
	public String getUrlLogo() {
		return urlLogo;
	}
	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	public List<Citizen> getMembers() {
		return members;
	}
	public void setMembers(List<Citizen> members) {
		this.members = members;
	}
	public long getVotes() {
		return votes;
	}
	public void setVotes(long votes) {
		this.votes = votes;
	}
		
}
