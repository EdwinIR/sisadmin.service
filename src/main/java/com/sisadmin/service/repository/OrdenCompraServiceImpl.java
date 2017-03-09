package com.sisadmin.service.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.OrdenCompraDetalle;
import com.sisadmin.repository.DetalleOrdenCompraRepository;
/**
 * DetalleOrdenCompraServiceImpl
 * @author ciro
 *
 */
@Service
public class OrdenCompraServiceImpl implements OrdenCompraService{
	
	private DetalleOrdenCompraRepository detalleOrdenCompraRepository;
	
	@Autowired
	public void setDetalleOrdenCompraRepository(
			DetalleOrdenCompraRepository detalleOrdenCompraRepository) {
		this.detalleOrdenCompraRepository = detalleOrdenCompraRepository;
	}

	public Collection<OrdenCompraDetalle> obtenerTodos() {
		return (Collection<OrdenCompraDetalle>) detalleOrdenCompraRepository.findAll();
	}

	public OrdenCompraDetalle findOne(Long id) {
		return detalleOrdenCompraRepository.findOne(id);
	}

	public OrdenCompraDetalle create(OrdenCompraDetalle detalleOrdenCompra) {
		return detalleOrdenCompraRepository.save(detalleOrdenCompra);
	}

	public OrdenCompraDetalle update(OrdenCompraDetalle detalleOrdenCompra) {
		return detalleOrdenCompraRepository.save(detalleOrdenCompra);
	}

	public void delete(Long id) {
		detalleOrdenCompraRepository.delete(id);
	}

	
	

}
