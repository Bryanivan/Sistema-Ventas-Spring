/**
 * 
 */
package com.carlos.sistemat3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.carlos.sistemat3.entidad.PlazoPago;
import com.carlos.sistemat3.repositorio.PlazoPagoJpaRepository;
/**
 * @author Carlos Chavez Laguna
 *
 */
@Service("plazoPagoServicio")
public class PlazoPagoServicio implements EntidadServicio<PlazoPago>{

	/*Injectando el repositorio de la entidad plazo pago*/
	@Autowired
	@Qualifier("plazoPagoJpaRepository")
	private PlazoPagoJpaRepository plazoPagoJpaRepository;
	
	@Override
	public List<PlazoPago> all() {
		// TODO Auto-generated method stub
		return plazoPagoJpaRepository.findAll();
	}

	@Override
	public PlazoPago get(int id) {
		// TODO Auto-generated method stub
		return plazoPagoJpaRepository.getOne(id);
	}

	@Override
	public PlazoPago add(PlazoPago plazoPago) {
		// TODO Auto-generated method stub
		return plazoPagoJpaRepository.save(plazoPago);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		plazoPagoJpaRepository.delete(id);
		return 0;
	}

	@Override
	public PlazoPago update(PlazoPago plazoPago) {
		plazoPagoJpaRepository.save(plazoPago);
		return null;
	}

}
