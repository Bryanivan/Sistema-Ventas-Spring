/**
 * 
 */
package com.carlos.sistemat3.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlos.sistemat3.entidad.Empleado;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Repository("empleadoJpaRepository")
public interface EmpleadoJpaRepository extends JpaRepository<Empleado,Serializable>{

}
