/**
 * 
 */
package com.carlos.sistemat3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.carlos.sistemat3.entidad.OrdenCompra;
import com.carlos.sistemat3.repositorio.OrdenCompraJpaRepository;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Service("ordenCompraServicio")
public class OrdenCompraServicio implements EntidadServicio<OrdenCompra>{
	
	@Autowired
	@Qualifier("ordenCompraJpaRepository")
	private OrdenCompraJpaRepository ordenCompraJpaRepository;
	
	@Override
	public List<OrdenCompra> all() {
		// TODO Auto-generated method stub
		return ordenCompraJpaRepository.findAll();
	}

	@Override
	public OrdenCompra get(int id) {
		// TODO Auto-generated method stub
		return ordenCompraJpaRepository.getOne(id);
	}

	@Override
	public OrdenCompra add(OrdenCompra ordenCompra) {
		// TODO Auto-generated method stub
		return ordenCompraJpaRepository.save(ordenCompra);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		ordenCompraJpaRepository.delete(id);
		return 0;
	}

	@Override
	public OrdenCompra update(OrdenCompra ordenCompra) {
		// TODO Auto-generated method stub		
		return ordenCompraJpaRepository.save(ordenCompra);
	}
	
}
