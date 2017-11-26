/**
 * 
 */
package com.carlos.sistemat3.repositorio;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carlos.sistemat3.entidad.Proveedor;
import java.util.List;

/**
 * 
 * Repositorio Proveedor
 * @author Carlos Chavez Laguna
 *
 */

@Repository("proveedorJpaRepository")
public interface ProveedorJpaRepository extends JpaRepository<Proveedor,Serializable>{
	List<Proveedor> findByRuc(String ruc);
	List<Proveedor> findByRazonSocialContaining(String razonSocial);
}
