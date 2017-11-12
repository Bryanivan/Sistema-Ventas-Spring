package com.carlos.sistemat3.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue
	@Column(name="idclie")
	private int id;
	
	@Column(name="rucdniclie")	
	private String rucODni;
		
	@Column(name="fullnameclie")	
	private String nombreCompleto;
	
	@Column(name="direccionfiscalclie")	
	private String direccionFiscal;
	
	@Column(name="direccionentregaclie")	
	private String direccionEntrega;
	
	@Column(name="telefonoclie")	
	private String telefono;
	
	@Column(name="emailclie")	
	private String email;

	/*Constructors*/	
	public Cliente() {
		
	}
	
	
	
	/**
	 * @param rUCoDni
	 * @param nombreCompleto
	 * @param direccionFiscal
	 * @param direccionEntrega
	 * @param telefono
	 * @param email
	 */
	public Cliente(String rUCoDni, String nombreCompleto, String direccionFiscal, String direccionEntrega,
			String telefono, String email) {
		super();
		rucODni = rUCoDni;
		this.nombreCompleto = nombreCompleto;
		this.direccionFiscal = direccionFiscal;
		this.direccionEntrega = direccionEntrega;
		this.telefono = telefono;
		this.email = email;
	}



	/**
	 * @param id
	 * @param rUCoDni
	 * @param nombreCompleto
	 * @param direccionFiscal
	 * @param direccionEntrega
	 * @param telefono
	 * @param email
	 */
	public Cliente(int id, String rUCoDni, String nombreCompleto, String direccionFiscal, String direccionEntrega,
			String telefono, String email) {
		super();
		this.id = id;
		rucODni = rUCoDni;
		this.nombreCompleto = nombreCompleto;
		this.direccionFiscal = direccionFiscal;
		this.direccionEntrega = direccionEntrega;
		this.telefono = telefono;
		this.email = email;
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
	 * @return the rUCoDni
	 */
	public String getRucODni() {
		return rucODni;
	}

	/**
	 * @param rUCoDni the rUCoDni to set
	 */
	public void setRucODni(String rUCoDni) {
		rucODni = rUCoDni;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @return the direccionFiscal
	 */
	public String getDireccionFiscal() {
		return direccionFiscal;
	}

	/**
	 * @param direccionFiscal the direccionFiscal to set
	 */
	public void setDireccionFiscal(String direccionFiscal) {
		this.direccionFiscal = direccionFiscal;
	}

	/**
	 * @return the direccionEntrega
	 */
	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	/**
	 * @param direccionEntrega the direccionEntrega to set
	 */
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
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
	
	
	
}
