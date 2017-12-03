package com.carlos.sistemat3.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.carlos.sistemat3.entidad.NotaCredito;
import com.carlos.sistemat3.repositorio.NotaCreditoJpaRepository;

@Service("notaCreditoServicio")
public class NotaCreditoServicio implements EntidadServicio<NotaCredito>{
	@Autowired
	@Qualifier("notaCreditoJpaRepository")
	private NotaCreditoJpaRepository notaCreditoJpaRepository;
	
	@Override
	public List<NotaCredito> all() {
		// TODO Auto-generated method stub
		return notaCreditoJpaRepository.findAll();
	}

	@Override
	public NotaCredito get(int id) {
		// TODO Auto-generated method stub
		return notaCreditoJpaRepository.getOne(id);
	}

	@Override
	public NotaCredito add(NotaCredito entidad) {
		// TODO Auto-generated method stub
		return notaCreditoJpaRepository.save(entidad);
	}

	@Override
	public int remove(int id) {
		// TODO Auto-generated method stub
		notaCreditoJpaRepository.delete(id);
		return 0;
	}

	@Override
	public NotaCredito update(NotaCredito entidad) {
		// TODO Auto-generated method stub		
		return notaCreditoJpaRepository.save(entidad);
	}
	
	public int exists(String facturaId) {
		return notaCreditoJpaRepository.exists(facturaId);
	}
}
