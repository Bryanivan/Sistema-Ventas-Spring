/**
 * 
 */
package com.carlos.sistemat3.repositorio;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carlos.sistemat3.entidad.DetalleCompra;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Repository("detalleCompraJpaRepository")
public interface DetalleCompraJpaRepository extends JpaRepository<DetalleCompra,Serializable> {
	List<DetalleCompra> findByOrdenCompraId(int ordenCompraId);
}
