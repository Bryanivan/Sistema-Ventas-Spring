package com.carlos.sistemat3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.carlos.sistemat3.entidad.Proveedor;
import com.carlos.sistemat3.repositorio.ProveedorJpaRepository;


/*
 * Servicio de proveedor
 * @author Carlos Chavez Laguna
 * */

@Service("proveedorServicio")
public class ProveedorServicio implements EntidadServicio<Proveedor>{

	/*Injectando el repositorio de la entidad proveedor*/
	@Autowired
	@Qualifier("proveedorJpaRepository")
	private ProveedorJpaRepository proveedorJpaRepository;
	
	@Override
	public List<Proveedor> all() { 
		return proveedorJpaRepository.findAll();
	}

	@Override
	public Proveedor get(int id) {
		return proveedorJpaRepository.getOne(id);
	}

	@Override
	public Proveedor add(Proveedor entidad) {
		return proveedorJpaRepository.save(entidad);
	}

	@Override
	public int remove(int id) {
		proveedorJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Proveedor update(Proveedor entidad) {
		return proveedorJpaRepository.save(entidad);
	}
	

	public List<Proveedor> findByRuc(String ruc){
		return proveedorJpaRepository.findByRuc(ruc);
	}

	public List<Proveedor> findByRazonSocial(String razonSocial){
		return proveedorJpaRepository.findByRazonSocialContaining(razonSocial);
	}

}
