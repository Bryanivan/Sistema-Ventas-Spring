package com.carlos.sistemat3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.carlos.sistemat3.entidad.NotaVenta;
import com.carlos.sistemat3.repositorio.NotaVentaJpaRepository;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Service("notaVentaServicio")
public class NotaVentaServicio implements EntidadServicio<NotaVenta>{
	/*Injectando el repositorio de la entidad cliente*/
	@Autowired
	@Qualifier("notaVentaJpaRepository")
	private NotaVentaJpaRepository notaVentaJpaRepository;

	@Override
	public List<NotaVenta> all() {
		// TODO Auto-generated method stub
		return notaVentaJpaRepository.findAll();
	}

	@Override
	public NotaVenta get(int id) {
		// TODO Auto-generated method stub
		return notaVentaJpaRepository.getOne(id);
	}

	@Override
	public NotaVenta add(NotaVenta notaVenta) {
		// TODO Auto-generated method stub
		return notaVentaJpaRepository.save(notaVenta);
	}

	@Override
	public int remove(int id) {
		notaVentaJpaRepository.delete(id);
		return 0;
	}

	@Override
	public NotaVenta update(NotaVenta notaVenta) {
		// TODO Auto-generated method stub
		return notaVentaJpaRepository.save(notaVenta);
	}
	
	public int getLastRowIndex() {
		return notaVentaJpaRepository.getLastRowIndex();
	}
}
