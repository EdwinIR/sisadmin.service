package com.sisadmin.service.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.Factura;
import com.sisadmin.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService{
	
	private FacturaRepository facturaRepository;
	
	@Autowired
	public void setFacturaRepository(FacturaRepository facturaRepository) {
		this.facturaRepository = facturaRepository;
	}

	public Collection<Factura> obtenerTodos() {
		return (Collection<Factura>) facturaRepository.findAll();
	}

	public Factura findOne(Long id) {
		return facturaRepository.findOne(id);
	}

	public Factura create(Factura factura) {
		return facturaRepository.save(factura);
	}

	public Factura update(Factura factura) {
		return facturaRepository.save(factura);
	}

	public void delete(Long id) {
		facturaRepository.delete(id);
	}

	

}
