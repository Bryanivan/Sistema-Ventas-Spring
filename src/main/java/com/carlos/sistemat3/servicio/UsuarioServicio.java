package com.carlos.sistemat3.servicio;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.carlos.sistemat3.entidad.User;
import com.carlos.sistemat3.repositorio.UserJpaRepository;

@Service("usuarioServicio")
public class UsuarioServicio implements EntidadServicio<User>{
	
	private final Log LOG= LogFactory.getLog(UsuarioServicio.class); 
	
	@Autowired
	@Qualifier("userJpaRepository")
	private UserJpaRepository userJpaRepository;
	
	@Override
	public List<User> all() { 
		LOG.info("getting all users!!!");		
		return userJpaRepository.findAll();
	}
	
	@Override
	public User get(int id) {
		return userJpaRepository.getOne(id);
	}
	
	@Override
	public User add(User usuario) { 
		return userJpaRepository.save(usuario);
	}

	@Override
	public int remove(int id) { 
		userJpaRepository.delete(id);
		return 0;
	}

	@Override
	public User update(User usuario) { 
		return userJpaRepository.save(usuario);
	}

	
	public int exists(String username, String password) {		
		return userJpaRepository.exists(username,password);
	}

	



}
