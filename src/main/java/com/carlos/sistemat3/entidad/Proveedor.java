/**
 * 
 */
package com.carlos.sistemat3.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Entity
@Table(name="proveedor")
public class Proveedor {
	@Id
	@GeneratedValue
	@Column(name="idprov")
	private int id;
	
	@Column(name="razonsocialprov")	
	private String razonSocial;
	
	@Column(name="rucprov")	
	private String RUC;
	
	@Column(name="emailprov")
	private String email;
	
	@Column(name="telefonoprov")	
	private String telefono;
	
	
	public Proveedor() {
		
	}
	
	/**
	 * @param id
	 * @param razonSocial
	 * @param rUC
	 * @param email
	 * @param telefono
	 */
	public Proveedor(int id, String razonSocial, String rUC, String email, String telefono) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		RUC = rUC;
		this.email = email;
		this.telefono = telefono;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * @return the rUC
	 */
	public String getRUC() {
		return RUC;
	}

	/**
	 * @param rUC the rUC to set
	 */
	public void setRUC(String rUC) {
		RUC = rUC;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
