package com.carlos.sistemat3.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="iduser")
	private int id;
	
	@Column(name="usuariouser")	
	private String username;
	
	@Column(name="passworduser")
	private String password;
	
	@Column(name="auth_token")
	private String authToken;
	
	@Column(name="remember_token")
	private String rememberToken;
		
	@Column(name="roles_idroles")
	private int rolId;
	
	/**
	 * 
	 */
	public User() {
		super();
	}

	public User(String username, String password) {
		super();		
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	

	/**
	 * @param username
	 * @param authToken
	 * @param rememberToken
	 */
	public User(String username, int rolId,String authToken, String rememberToken) {
		super();
		this.username = username;
		this.rolId=rolId;
		this.authToken = authToken;
		this.rememberToken = rememberToken;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the authToken
	 */
	public String getAuthToken() {
		return authToken;
	}

	/**
	 * @param authToken the authToken to set
	 */
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	/**
	 * @return the rememberToken
	 */
	public String getRememberToken() {
		return rememberToken;
	}

	/**
	 * @param rememberToken the rememberToken to set
	 */
	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	/**
	 * @return the rolId
	 */
	public int getRolId() {
		return rolId;
	}

	/**
	 * @param rolId the rolId to set
	 */
	public void setRolId(int rolId) {
		this.rolId = rolId;
	}
	
	
	
}
