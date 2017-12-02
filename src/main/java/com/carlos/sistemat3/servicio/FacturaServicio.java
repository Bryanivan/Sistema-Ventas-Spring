/**
 * 
 */
package com.carlos.sistemat3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.carlos.sistemat3.entidad.Factura;
import com.carlos.sistemat3.repositorio.FacturaJpaRepository;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Service("facturaServicio")
public class FacturaServicio implements EntidadServicio<Factura>{
	/*Injectando el repositorio de la entidad cliente*/
	@Autowired
	@Qualifier("facturaJpaRepository")
	private FacturaJpaRepository facturaJpaRepository;
	
	@Override
	public List<Factura> all() {
		// TODO Auto-generated method stub
		return facturaJpaRepository.findAll();
	}

	@Override
	public Factura get(int id) {
		// TODO Auto-generated method stub
		return facturaJpaRepository.getOne(id);
	}

	@Override
	public Factura add(Factura factura) {
		// TODO Auto-generated method stub		
		return facturaJpaRepository.save(factura);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		facturaJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Factura update(Factura factura) {
		// TODO Auto-generated method stub
		return facturaJpaRepository.save(factura);
	}
	
	public int getLastRowCodigo() {
		return facturaJpaRepository.getLastRowCodigo();
	}
}
