/**
 * 
 */
package com.carlos.sistemat3.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Entity
@Table(name="factura")
public class Factura {
	@Id
	@GeneratedValue
	@Column(name="idfactura")
	private int id;
	
	@Column(name="numerofact")
	private String codigo;
	
	/*@Column(name = "startTime", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)*/	
	//formato date time YYYY-MM-DD HH:MM:SS	
	@Column(name="fechaemisionfact")
	private String fechaEmision;
	
	@Column(name="fechavencimientofact")
	private String fechaVencimiento;
	
	@Column(name="subtotal")
	private float subTotal;
	
	@Column(name="descuento")
	private float descuento;
	
	@Column(name="igv")
	private float igv;
	
	@Column(name="total")
	private float total;
	
	@Column(name="empleados_idempl")
	private float empleadoId;
	
	@Column(name="plazopago_idplazopago")
	private float plazoPagoId;
	
	//falta guía de remición
	
	@Column(name="estadostablas_idestadostabla")
	private float estadoId;
	
	@Column(name="clientes_idclie")
	private float clienteId;

	
	
	
	
	/**
	 * 
	 */
	public Factura() {
		super();
	}

	/**
	 * @param id
	 * @param codigo
	 * @param fechaEmision
	 * @param fechaVencimiento
	 * @param subTotal
	 * @param descuento
	 * @param igv
	 * @param total
	 * @param empleadoId
	 * @param plazoPagoId
	 * @param estadosTablasId
	 * @param clientesId
	 */
	public Factura(int id, String codigo, String fechaEmision, String fechaVencimiento, float subTotal, float descuento,
			float igv, float total, float empleadoId, float plazoPagoId, float estadosTablasId, float clientesId) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.subTotal = subTotal;
		this.descuento = descuento;
		this.igv = igv;
		this.total = total;
		this.empleadoId = empleadoId;
		this.plazoPagoId = plazoPagoId;
		this.estadoId = estadosTablasId;
		this.clienteId = clientesId;
	}
	
	
	
	/**
	 * @param codigo
	 * @param fechaEmision
	 * @param fechaVencimiento
	 * @param subTotal
	 * @param descuento
	 * @param igv
	 * @param total
	 * @param empleadoId
	 * @param plazoPagoId
	 * @param estadosTablasId
	 * @param clientesId
	 */
	public Factura(String codigo, String fechaEmision, String fechaVencimiento, float subTotal, float descuento,
			float igv, float total, float empleadoId, float plazoPagoId, float estadosTablasId, float clienteId) {
		super();
		this.codigo = codigo;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
		this.subTotal = subTotal;
		this.descuento = descuento;
		this.igv = igv;
		this.total = total;
		this.empleadoId = empleadoId;
		this.plazoPagoId = plazoPagoId;
		this.estadoId = estadosTablasId;
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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return the fechaVencimiento
	 */
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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
	 * @return the empleadoId
	 */
	public float getEmpleadoId() {
		return empleadoId;
	}

	/**
	 * @param empleadoId the empleadoId to set
	 */
	public void setEmpleadoId(float empleadoId) {
		this.empleadoId = empleadoId;
	}

	/**
	 * @return the plazoPagoId
	 */
	public float getPlazoPagoId() {
		return plazoPagoId;
	}

	/**
	 * @param plazoPagoId the plazoPagoId to set
	 */
	public void setPlazoPagoId(float plazoPagoId) {
		this.plazoPagoId = plazoPagoId;
	}

	

	/**
	 * @return the estadoId
	 */
	public float getEstadoId() {
		return estadoId;
	}

	/**
	 * @param estadoId the estadoId to set
	 */
	public void setEstadoId(float estadoId) {
		this.estadoId = estadoId;
	}

	/**
	 * @return the clientesId
	 */
	public float getClienteId() {
		return clienteId;
	}

	/**
	 * @param clientesId the clientesId to set
	 */
	public void setClienteId(float clienteId) {
		this.clienteId = clienteId;
	}
	
	
	
	
	
}
