/**
 * Partido Político
 */
package com.elecc.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ramón Cigüenza
 *
 */
public class Party implements Serializable {

	/**
	 * Default serializable object ID 
	 */
	private static final long serialVersionUID = 1L;
	
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
