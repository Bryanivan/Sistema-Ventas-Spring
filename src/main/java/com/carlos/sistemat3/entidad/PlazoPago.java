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
@Table(name="plazopago")
public class PlazoPago {	
	@Id
	@GeneratedValue
	@Column(name="idplazopago")
	private int id;
	
	@Column(name="descripcionplap")	
	private String descripcion;
	
	
	public PlazoPago() {		
	}
	
	/**
	 * @param id
	 * @param descripcion
	 */
	public PlazoPago(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
