/**
 * 
 */
package com.carlos.sistemat3.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carlos.sistemat3.entidad.DetalleVenta;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Repository("detalleVentaJpaRepository")
public interface DetalleVentaJpaRepository extends JpaRepository<DetalleVenta,Serializable>{
	List<DetalleVenta> findByNotaVentasId(int notaVentasId);
	List<DetalleVenta> findByFacturaId(int facturaId);
}
