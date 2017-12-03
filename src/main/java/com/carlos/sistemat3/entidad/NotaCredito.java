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
 * @author Juan Carlos Cubas
 *
 */
@Entity
@Table(name="notascreditos")
public class NotaCredito {
	@Id
	@GeneratedValue
	@Column(name="idnotacreditos")
	private int id;
	
	@Column(name="factura_idfactura")
	private int idFactura;

	
	
	/**
	 * 
	 */
	public NotaCredito() {
		super();
	}



	/**
	 * @param id
	 * @param idFactura
	 */
	public NotaCredito(int id, int idFactura) {
		super();
		this.id = id;
		this.idFactura = idFactura;
	}
	
	

	/**
	 * @param idFactura
	 */
	public NotaCredito(int idFactura) {
		super();
		this.idFactura = idFactura;
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
	 * @return the idFactura
	 */
	public int getIdFactura() {
		return idFactura;
	}

	/**
	 * @param idFactura the idFactura to set
	 */
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	
	
	
}
