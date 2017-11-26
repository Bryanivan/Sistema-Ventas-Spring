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
 * 
 * Entidad Proveedor
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
	private String ruc;
	
	@Column(name="emailprov")
	private String email;
	
	@Column(name="telefonoprov")	
	private String telefono;
	
	@Column(name="estadostablas_idestadostabla")
	private int estadoId;
	
	public Proveedor() {
		
	}
	
	
	
	/**
	 * @param razonSocial
	 * @param rUC
	 * @param email
	 * @param telefono
	 */
	public Proveedor(String razonSocial, String ruc, String email, String telefono) {
		super();
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.email = email;
		this.telefono = telefono;
	}



	/**
	 * @param id
	 * @param razonSocial
	 * @param rUC
	 * @param email
	 * @param telefono
	 */
	public Proveedor(int id, String razonSocial, String ruc, String email, String telefono) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.email = email;
		this.telefono = telefono;
	}

	
	
	
	/**
	 * @param id
	 * @param razonSocial
	 * @param rUC
	 * @param email
	 * @param telefono
	 * @param estadoId
	 */
	public Proveedor(int id, String razonSocial, String ruc, String email, String telefono, int estadoId) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.email = email;
		this.telefono = telefono;
		this.estadoId = estadoId;
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
	 * @return the ruc
	 */
	public String getRuc() {
		return ruc;
	}



	/**
	 * @param ruc the ruc to set
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
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



	/**
	 * @return the estadoId
	 */
	public int getEstadoId() {
		return estadoId;
	}



	/**
	 * @param estadoId the estadoId to set
	 */
	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}
	
	
}
