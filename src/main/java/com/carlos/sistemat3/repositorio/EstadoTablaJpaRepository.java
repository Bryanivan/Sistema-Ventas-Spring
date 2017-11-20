/**
 * 
 */
package com.carlos.sistemat3.repositorio;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carlos.sistemat3.entidad.EstadoTabla;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Repository("estadoTablaJpaRepository")
public interface EstadoTablaJpaRepository extends JpaRepository<EstadoTabla,Serializable>{
	List<EstadoTabla> findByNombreTabla(String nombreTabla); 
}
