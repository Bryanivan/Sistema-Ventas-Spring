/**
 * 
 */
package com.carlos.sistemat3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.carlos.sistemat3.entidad.Rol;
import com.carlos.sistemat3.repositorio.RolJpaRepository;

/**
 * @author Carlos Chavez Laguna
 *
 */

@Service("rolServicio")
public class RolServicio implements EntidadServicio<Rol>{
	
	@Autowired
	@Qualifier("rolJpaRepository")
	private RolJpaRepository rolJpaRepository;
	
	@Override
	public List<Rol> all() {
		// TODO Auto-generated method stub
		return rolJpaRepository.findAll();
	}

	@Override
	public Rol get(int id) {
		// TODO Auto-generated method stub
		return rolJpaRepository.getOne(id);
	}

	@Override
	public Rol add(Rol rol) {
		// TODO Auto-generated method stub
		return rolJpaRepository.save(rol);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		rolJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Rol update(Rol rol) {
		// TODO Auto-generated method stub
		return rolJpaRepository.save(rol);
	}

}
