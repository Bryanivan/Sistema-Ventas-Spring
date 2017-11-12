/**
 * 
 */
package com.carlos.sistemat3.repositorio;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carlos.sistemat3.entidad.Cliente;

/**
 * @author Carlos
 *
 */
@Repository("clienteJpaRepository")
public interface ClienteJpaRepository extends JpaRepository<Cliente,Serializable>{
	List<Cliente> findByRucODni(String RucODni); 
}
