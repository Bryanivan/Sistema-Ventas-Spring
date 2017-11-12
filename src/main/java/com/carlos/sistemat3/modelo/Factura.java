package com.carlos.sistemat3.modelo;

public class Factura {
	private int id;
	private Producto[] productos;	
	private int total ;
	
	
	
	public Factura(int id, Producto[] productos) {
		super();
		this.id = id;
		this.productos = productos;
		this.total = 0;
		for(Producto producto: productos)
			this.total +=producto.getPrecio();		 
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Producto[] getProductos() {
		return productos;
	}
	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
