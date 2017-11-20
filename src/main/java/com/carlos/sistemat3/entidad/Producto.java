package com.carlos.sistemat3.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue
	@Column(name="idprod")
	private int id;
	
	@Column(name="descripcionprod")	
	private String descripcion;
	
	@Column(name="preciocompraprod")	
	private float precioCompra;
	
	@Column(name="precioventacontadoprod")	
	private float precioVenta;
	
	@Column(name="precioventasieteprod")	
	private float precioPack7;
	
	@Column(name="precioventaquinceprod")	
	private float precioPack15;
	
	@Column(name="stockprod")	
	private float stock;
	
	/*@ManyToOne
	@JoinColumn(name="estadostablas_idestadostabla")
	private Estado estado;*/
	
	
	/*Constructors*/	
	public Producto() {
		
	}
	
	
	
	/**
	 * @param descripcion
	 * @param precioCompra
	 * @param precioVenta
	 * @param precioPack7
	 * @param precioPack15
	 * @param stock
	 */
	public Producto(String descripcion, float precioCompra, float precioVenta, float precioPack7, float precioPack15,
			float stock) {
		super();
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.precioPack7 = precioPack7;
		this.precioPack15 = precioPack15;
		this.stock = stock;
	}



	/**
	 * @param id
	 * @param descripcion
	 * @param precioCompra
	 * @param precioVenta
	 * @param precioPack7
	 * @param precioPack15
	 * @param stock
	 */
	public Producto(int id, String descripcion, float precioCompra, float precioVenta, float precioPack7,
			float precioPack15, float stock) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.precioPack7 = precioPack7;
		this.precioPack15 = precioPack15;
		this.stock = stock;
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
	 * @return the precioCompra
	 */
	public float getPrecioCompra() {
		return precioCompra;
	}




	/**
	 * @param precioCompra the precioCompra to set
	 */
	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}




	/**
	 * @return the precioVenta
	 */
	public float getPrecioVenta() {
		return precioVenta;
	}




	/**
	 * @param precioVenta the precioVenta to set
	 */
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}




	/**
	 * @return the precioPack7
	 */
	public float getPrecioPack7() {
		return precioPack7;
	}




	/**
	 * @param precioPack7 the precioPack7 to set
	 */
	public void setPrecioPack7(float precioPack7) {
		this.precioPack7 = precioPack7;
	}




	/**
	 * @return the precioPack15
	 */
	public float getPrecioPack15() {
		return precioPack15;
	}




	/**
	 * @param precioPack15 the precioPack15 to set
	 */
	public void setPrecioPack15(float precioPack15) {
		this.precioPack15 = precioPack15;
	}




	/**
	 * @return the stock
	 */
	public float getStock() {
		return stock;
	}




	/**
	 * @param stock the stock to set
	 */
	public void setStock(float stock) {
		this.stock = stock;
	}

	
	
}
