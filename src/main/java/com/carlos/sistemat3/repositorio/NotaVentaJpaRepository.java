/**
 * 
 */
package com.carlos.sistemat3.repositorio;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.carlos.sistemat3.entidad.NotaVenta;

/**
 * @author Carlos Chavez Laguna
 *
 */

@Repository("notaVentaJpaRepository")
public interface NotaVentaJpaRepository extends JpaRepository<NotaVenta,Serializable>{
	@Query(value="SELECT idnotadeventa FROM notaventas GROUP BY idnotadeventa DESC LIMIT 1",nativeQuery = true)
	int getLastRowIndex();
}
