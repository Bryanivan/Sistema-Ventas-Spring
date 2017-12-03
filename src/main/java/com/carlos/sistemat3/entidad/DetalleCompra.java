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
@Table(name="detalleordencompras")
public class DetalleCompra {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;	
		
	@Column(name="productos_idprod")
	private int productoId;
	
	@Column(name="ordencompras_idordendecompra")
	private int ordenCompraId;
	
	@Column(name="cantidaddeoc")
	private int cantidad;
	
	@Column(name="preciocompradeoc")
	private float precioCompra;
	
		
	
	
	/**
	 * 
	 */
	public DetalleCompra() {
		super();
	}

	

	/**
	 * @param productoId
	 * @param ordenCompraId
	 * @param cantidad
	 * @param precio
	 */
	public DetalleCompra(int productoId, int ordenCompraId, int cantidad, float precio) {
		super();
		this.productoId = productoId;
		this.ordenCompraId = ordenCompraId;
		this.cantidad = cantidad;
		this.precioCompra = precio;
	}



	/**
	 * @param id
	 * @param productoId
	 * @param ordenCompraId
	 * @param cantidad
	 * @param precio
	 */
	public DetalleCompra(int id, int productoId, int ordenCompraId, int cantidad, float precio) {
		super();
		this.id = id;
		this.productoId = productoId;
		this.ordenCompraId = ordenCompraId;
		this.cantidad = cantidad;
		this.precioCompra = precio;
	}

	

	/**
	 * @param id
	 * @param productoId
	 * @param ordenCompraId
	 * @param cantidad
	 * @param precio
	 * @param producto
	 */
	public DetalleCompra(int id, int productoId, int ordenCompraId, int cantidad, float precio, Producto producto) {
		super();
		this.id = id;
		this.productoId = productoId;
		this.ordenCompraId = ordenCompraId;
		this.cantidad = cantidad;
		this.precioCompra = precio;
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
	 * @return the ordenCompraId
	 */
	public int getOrdenCompraId() {
		return ordenCompraId;
	}


	/**
	 * @param ordenCompraId the ordenCompraId to set
	 */
	public void setOrdenCompraId(int ordenCompraId) {
		this.ordenCompraId = ordenCompraId;
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
	public float getPrecioCompra() {
		return precioCompra;
	}


	/**
	 * @param precio the precio to set
	 */
	public void setPrecioCompra(float precio) {
		this.precioCompra = precio;
	}

	
	
}

