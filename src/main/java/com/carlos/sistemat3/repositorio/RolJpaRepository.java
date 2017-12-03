package com.carlos.sistemat3.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carlos.sistemat3.entidad.Rol;

@Repository("rolJpaRepository")
public interface RolJpaRepository extends JpaRepository<Rol,Serializable>{

}
