package com.carlos.sistemat3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.carlos.sistemat3.entidad.Cliente;
import com.carlos.sistemat3.repositorio.ClienteJpaRepository;

/**
 * @author Carlos Chavez Laguna
 *
 */
@Service("clienteServicio")
public class ClienteServicio implements EntidadServicio<Cliente>{
	@Autowired
	@Qualifier("clienteJpaRepository")
	private ClienteJpaRepository clienteJpaRepository;
	
	@Override
	public List<Cliente> all() {
		return clienteJpaRepository.findAll();
	}

	@Override
	public Cliente get(int id) {
		// TODO Auto-generated method stub
		return clienteJpaRepository.getOne(id);
	}

	@Override
	public Cliente add(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteJpaRepository.save(cliente);
	}

	@Override
	public int remove(int id) {
		clienteJpaRepository.delete(id);
		return 0;
	}

	@Override
	public Cliente update(Cliente cliente) {		
		return clienteJpaRepository.save(cliente);
	}
	
	
	public List<Cliente> findByRucODni(String rucODni) {
		return clienteJpaRepository.findByRucODni(rucODni);
	}
}
