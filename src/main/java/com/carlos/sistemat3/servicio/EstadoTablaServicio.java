/**
 * 
 */
package com.carlos.sistemat3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.carlos.sistemat3.repositorio.EstadoTablaJpaRepository;
import com.carlos.sistemat3.entidad.EstadoTabla;
/**
 * @author Carlos Chavez Laguna
 *
 */
@Service("estadoTablaServicio")
public class EstadoTablaServicio implements EntidadServicio<EstadoTabla>{
	
	/*Injectando el repositorio de la entidad cliente*/
	@Autowired
	@Qualifier("estadoTablaJpaRepository")
	private EstadoTablaJpaRepository estadoTablaJpaRepository;
	
	@Override
	public List<EstadoTabla> all() {
		return estadoTablaJpaRepository.findAll();
	}

	@Override
	public EstadoTabla get(int id) {
		return estadoTablaJpaRepository.getOne(id);
	}

	@Override
	public EstadoTabla add(EstadoTabla estadoTabla) {
		return estadoTablaJpaRepository.save(estadoTabla);
	}

	@Override
	public int remove(int id) {
		estadoTablaJpaRepository.delete(id);		
		return 0;
	}

	@Override
	public EstadoTabla update(EstadoTabla estadoTabla) { 
		return estadoTablaJpaRepository.save(estadoTabla);
	}

	
	public List<EstadoTabla> findByNombreTabla(String nombreTabla)  {
		return estadoTablaJpaRepository.findByNombreTabla(nombreTabla);
	}
}
