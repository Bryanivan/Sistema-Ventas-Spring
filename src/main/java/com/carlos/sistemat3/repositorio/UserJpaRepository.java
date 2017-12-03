package com.carlos.sistemat3.repositorio;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.carlos.sistemat3.entidad.User;

@Repository("userJpaRepository")
public interface UserJpaRepository extends JpaRepository<User,Serializable>{
	
	@Query(value="SELECT count(*) FROM user WHERE usuariouser=?1 AND passworduser=?2",nativeQuery = true)
	int exists(String username, String password);
	
	List<User> findByAuthToken(String authToken);
	
}
