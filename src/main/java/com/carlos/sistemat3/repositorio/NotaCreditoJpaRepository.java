package com.carlos.sistemat3.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.carlos.sistemat3.entidad.NotaCredito;

@Repository("notaCreditoJpaRepository")
public interface NotaCreditoJpaRepository extends JpaRepository<NotaCredito,Serializable>{
	@Query(value="SELECT count(*) FROM notascreditos WHERE factura_idfactura=?1",nativeQuery = true)
	int exists(String facturaId);
}
