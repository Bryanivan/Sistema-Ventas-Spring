/**
 * 
 */
package com.carlos.sistemat3.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Entity
@Table(name="estadostablas")
public class EstadoTabla {
	@Id
	@GeneratedValue
	@Column(name="idestadostabla")
	private int id;
	
	@Column(name="nametabla")
	private String nombreTabla;
	
	@ManyToOne
	@JoinColumn(name="descripcionestados_iddescripcionestados")
	private Estado estado;
	
	
	

	/**
	 * 
	 */
	public EstadoTabla() {
		this.nombreTabla = "";
	}




	/**
	 * @param id
	 * @param nombreTabla
	 */
	public EstadoTabla(int id, String nombreTabla) {
		super();
		this.id = id;
		this.nombreTabla = nombreTabla;
	}




	/**
	 * @param id
	 * @param nombreTabla
	 * @param estado
	 */
	public EstadoTabla(int id, String nombreTabla, Estado estado) {
		super();
		this.id = id;
		this.nombreTabla = nombreTabla;
		this.estado = estado;
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
	 * @return the nombreTabla
	 */
	public String getNombreTabla() {
		return nombreTabla;
	}




	/**
	 * @param nombreTabla the nombreTabla to set
	 */
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}




	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}




	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	

}
