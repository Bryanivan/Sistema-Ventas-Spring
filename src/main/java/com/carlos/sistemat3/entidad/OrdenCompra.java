/**
 * 
 */
package com.carlos.sistemat3.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="ordencompras")
public class OrdenCompra {
	@Id
	@GeneratedValue
	@Column(name="idordendecompra")
	private int id;
	
	@Column(name="proveedor_idprov")
	private int proveedorId;
	
	@Column(name="subtotalordc")
	private float subTotal;
	
	@Column(name="igvordc")
	private float igv;
		
	@Column(name="totalordc")
	private float total;
	
	@Column(name="fechaordc")
	private String fecha;

	
	/**
	 * 
	 */
	public OrdenCompra() {
		super();
	}

	

	/**
	 * @param id
	 * @param proveedorId
	 * @param subTotal
	 * @param igv
	 * @param total
	 * @param fecha
	 */
	public OrdenCompra(int id, int proveedorId, float subTotal, float igv, float total, String fecha) {
		super();
		this.id = id;
		this.proveedorId = proveedorId;
		this.subTotal = subTotal;
		this.igv = igv;
		this.total = total;
		this.fecha = fecha;
	}



	/**
	 * @param proveedorId
	 * @param subTotal
	 * @param igv
	 * @param total
	 * @param fecha
	 */
	public OrdenCompra(int proveedorId, float subTotal, float igv, float total, String fecha) {
		super();
		this.proveedorId = proveedorId;
		this.subTotal = subTotal;
		this.igv = igv;
		this.total = total;
		this.fecha = fecha;
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
	 * @return the proveedorId
	 */
	public int getProveedorId() {
		return proveedorId;
	}



	/**
	 * @param proveedorId the proveedorId to set
	 */
	public void setProveedorId(int proveedorId) {
		this.proveedorId = proveedorId;
	}



	/**
	 * @return the subTotal
	 */
	public float getSubTotal() {
		return subTotal;
	}



	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}



	/**
	 * @return the igv
	 */
	public float getIgv() {
		return igv;
	}



	/**
	 * @param igv the igv to set
	 */
	public void setIgv(float igv) {
		this.igv = igv;
	}



	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}



	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}



	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}



	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
