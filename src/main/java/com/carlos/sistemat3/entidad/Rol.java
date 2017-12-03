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
@Table(name="roles")
public class Rol {
	@Id
	@GeneratedValue
	@Column(name="idroles")
	private int id;
	
	@Column(name="descripcionrole")
	private String descripcion;
	
	@Column(name="modulos")
	private String modulos;

	
	
	
	/**
	 * 
	 */
	public Rol() {
		super();
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param modulos
	 */
	public Rol(int id, String descripcion, String modulos) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.modulos = modulos;
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

	/**
	 * @return the modulos
	 */
	public String getModulos() {
		return modulos;
	}

	/**
	 * @param modulos the modulos to set
	 */
	public void setModulos(String modulos) {
		this.modulos = modulos;
	}
	
	
}
