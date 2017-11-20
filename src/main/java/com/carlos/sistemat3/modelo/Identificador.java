/**
 * 
 */
package com.carlos.sistemat3.modelo;

/**
 * Identificador
 * Objeto simple que solo sirve para respuestas donde
 * este devuelve un identificador (id) de una entidad
 * @author Carlos Chavez Laguna
 *
 */
public class Identificador {
	private int id;
	
	
	/**
	 * 
	 */
	public Identificador() {
		super();
		this.id=0;
	}

	/**
	 * @param id
	 */
	public Identificador(int id) {
		super();
		this.id = id;
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
	
}
