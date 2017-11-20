package com.carlos.sistemat3.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Entity
@Table(name="descripcionestados")
public class Estado {
	@Id
	@GeneratedValue
	@Column(name="iddescripcionestados")
	private int id;
	
	@Column(name="descripciondese")
	private String descripcion;

	/*@OneToMany(mappedBy="estado")
	private List<EstadoTabla> estadoTablas;*/
	
	public Estado() {
		
	}
	
	/**
	 * @param id
	 * @param descripcion
	 */
	public Estado(int id, String descripcion) {
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
