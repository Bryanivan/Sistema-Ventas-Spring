package com.carlos.sistemat3.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipoempleados")
public class TipoEmpleado {
	@Id
	@GeneratedValue
	@Column(name="idtipe")
	private int id;
	
	@Column(name="descripciontipe")
	private int descripcion;
	
	
	
	/**
	 * 
	 */
	public TipoEmpleado() {
		super();
	}

	/**
	 * @param id
	 * @param descripcion
	 */
	public TipoEmpleado(int id, int descripcion) {
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
	public int getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
