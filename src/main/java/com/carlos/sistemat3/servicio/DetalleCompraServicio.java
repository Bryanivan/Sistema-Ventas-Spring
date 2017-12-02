/**
 * 
 */
package com.carlos.sistemat3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.carlos.sistemat3.entidad.DetalleCompra;
import com.carlos.sistemat3.repositorio.DetalleCompraJpaRepository;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Service("detalleCompraServicio")
public class DetalleCompraServicio implements EntidadServicio<DetalleCompra>{
	/*Injectando el repositorio de la entidad detalle compra*/
	@Autowired
	@Qualifier("detalleCompraJpaRepository")
	private DetalleCompraJpaRepository detalleCompraJpaRepository;
	
	@Override
	public List<DetalleCompra> all() {
		// TODO Auto-generated method stub
		return detalleCompraJpaRepository.findAll();
	}

	@Override
	public DetalleCompra get(int id) {
		// TODO Auto-generated method stub
		return detalleCompraJpaRepository.getOne(id);
	}

	@Override
	public DetalleCompra add(DetalleCompra detalleCompra) {
		// TODO Auto-generated method stub
		return detalleCompraJpaRepository.save(detalleCompra);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		detalleCompraJpaRepository.delete(id);
		return 0;
	}

	@Override
	public DetalleCompra update(DetalleCompra detalleCompra) {
		// TODO Auto-generated method stub
		return detalleCompraJpaRepository.save(detalleCompra);
	}

	public List<DetalleCompra> findByOrdenCompraId(int ordenCompraId){
		return detalleCompraJpaRepository.findByOrdenCompraId(ordenCompraId);
	}
}
