/**
 * 
 */
package com.carlos.sistemat3.repositorio;

import org.springframework.stereotype.Repository;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.carlos.sistemat3.entidad.Producto;

/**
 * @author Carlos Chavez Laguna
 *
 */

@Repository("productoJpaRepository")
public interface ProductoJpaRepository extends JpaRepository<Producto,Serializable>{
	
}
