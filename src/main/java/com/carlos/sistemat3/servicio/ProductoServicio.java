/**
 * 
 */
package com.carlos.sistemat3.servicio;

import java.util.List;

import com.carlos.sistemat3.entidad.Producto;
import com.carlos.sistemat3.repositorio.ProductoJpaRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/**
 * @author Carlos Chavez Laguna
 *
 */
@Service("productoServicio")
public class ProductoServicio implements EntidadServicio<Producto>{
	
	
	private final Log LOG= LogFactory.getLog(ProductoServicio.class); 
	
	@Autowired
	@Qualifier("productoJpaRepository")
	private ProductoJpaRepository productoJpaRepository;
	
	
	@Override
	public List<Producto> all() {
		return productoJpaRepository.findAll();
	}

	@Override
	public Producto get(int id) {
		return productoJpaRepository.getOne(id);
	}
	
	@Override
	public Producto add(Producto producto) {
		// TODO Auto-generated method stub
		return productoJpaRepository.save(producto);
	}

	@Override
	public int remove(int id) {
		productoJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Producto update(Producto producto) {
		// TODO Auto-generated method stub
		return productoJpaRepository.save(producto);
	}

	
	
	public List<Producto> findById(int id){
		return productoJpaRepository.findById(id);
	}
	
	public List<Producto> findByNombre(String nombre){
		return productoJpaRepository.findByDescripcion(nombre);
	}
	
	

}
