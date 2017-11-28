/**
 * 
 */
package com.carlos.sistemat3.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.sistemat3.entidad.PlazoPago;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Repository("plazoPagoJpaRepository")
public interface PlazoPagoJpaRepository extends JpaRepository<PlazoPago,Serializable> {
	
	

}
