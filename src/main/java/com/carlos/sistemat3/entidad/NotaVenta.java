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
@Table(name="notaventas")
public class NotaVenta {
	@Id
	@GeneratedValue
	@Column(name="idnotadeventa")
	private int id;
	
	@Column(name="fechaemisionnotv")
	private String fechaEmision;
	
	@Column(name="subtotalnotv")
	private float subTotal;
	
	@Column(name="descuentonotv")
	private float descuento;
	
	@Column(name="igvnotv")
	private float igv;
	
	@Column(name="totalnotv")
	private float total;
		
	@Column(name="plazopago_idplazopago")
	private String plazoPagoId;
	
	@Column(name="clientes_idclie")
	private String clienteId;

	@Column(name="estadostablas_idestadostabla")
	private float estadoId;
	
	/**
	 * 
	 */
	public NotaVenta() {
		super();
	}

	/**
	 * @param id
	 * @param fechaEmision
	 * @param subTotal
	 * @param descuento
	 * @param igv
	 * @param total
	 * @param plazoPago
	 * @param clienteId
	 */
	public NotaVenta(int id, String fechaEmision, float subTotal, float descuento, float igv, float total,
			String plazoPago, String clienteId) {
		super();
		this.id = id;
		this.fechaEmision = fechaEmision;
		this.subTotal = subTotal;
		this.descuento = descuento;
		this.igv = igv;
		this.total = total;
		this.plazoPagoId = plazoPago;
		this.clienteId = clienteId;
	}
	
	

	/**
	 * @param fechaEmision
	 * @param subTotal
	 * @param descuento
	 * @param igv
	 * @param total
	 * @param plazoPagoId
	 * @param clienteId
	 */
	public NotaVenta(String fechaEmision, float subTotal, float descuento, float igv, float total, String plazoPagoId,
			String clienteId) {
		super();
		this.fechaEmision = fechaEmision;
		this.subTotal = subTotal;
		this.descuento = descuento;
		this.igv = igv;
		this.total = total;
		this.plazoPagoId = plazoPagoId;
		this.clienteId = clienteId;
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
	 * @return the fechaEmision
	 */
	public String getFechaEmision() {
		return fechaEmision;
	}

	/**
	 * @param fechaEmision the fechaEmision to set
	 */
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
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
	 * @return the descuento
	 */
	public float getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
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
	 * @return the plazoPago
	 */
	public String getPlazoPagoId() {
		return plazoPagoId;
	}

	/**
	 * @param plazoPago the plazoPago to set
	 */
	public void setPlazoPagoId(String plazoPago) {
		this.plazoPagoId = plazoPago;
	}

	/**
	 * @return the clienteId
	 */
	public String getClienteId() {
		return clienteId;
	}

	/**
	 * @param clienteId the clienteId to set
	 */
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	
	
}
