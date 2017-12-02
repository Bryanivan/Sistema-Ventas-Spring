package com.carlos.sistemat3.entidad;
/*
 * @author Carlos Chavez Laguna
 * */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detallefactura")
public class DetalleVenta {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="cantidaddetf")
	private int cantidad;

	/*@Column(name="descuentodetf")
	private float descuento; -no va, por las reglas que indican en el boceto que enviaron-*/
	
	@Column(name="productos_idprod")
	private int productoId;
	
	@Column(name="importedetf")
	private float precio;
	
	@Column(name="notaventas_idnotadeventa")
	private int notaVentasId; //si está relacionada a una nota de venta
	
	@Column(name="factura_idfactura")
	private int facturaId; //si está relacionada a una factura


	/**
	 * @param id
	 * @param cantidad
	 * @param productoId
	 * @param precio
	 * @param notaVentasId
	 * @param facturaId
	 */
	public DetalleVenta(int id, int cantidad, int productoId, float precio, int notaVentasId, int facturaId) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.productoId = productoId;
		this.precio = precio;
		this.notaVentasId = notaVentasId;
		this.facturaId = facturaId;
	}

	/**
	 * 
	 */
	public DetalleVenta() {
		super();
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
	 * @return the productoId
	 */
	public int getProductoId() {
		return productoId;
	}

	/**
	 * @param productoId the productoId to set
	 */
	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * @return the notaVentasId
	 */
	public int getNotaVentasId() {
		return notaVentasId;
	}

	/**
	 * @param notaVentasId the notaVentasId to set
	 */
	public void setNotaVentasId(int notaVentasId) {
		this.notaVentasId = notaVentasId;
	}

	/**
	 * @return the facturaId
	 */
	public int getFacturaId() {
		return facturaId;
	}

	/**
	 * @param facturaId the facturaId to set
	 */
	public void setFacturaId(int facturaId) {
		this.facturaId = facturaId;
	}
	
	
}
