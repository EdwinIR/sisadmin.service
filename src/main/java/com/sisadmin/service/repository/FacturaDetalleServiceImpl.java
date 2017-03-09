package com.sisadmin.service.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.FacturaDetalle;
import com.sisadmin.repository.DetalleFacturaProductoRepository;

/**
 * 
 * @author ciro
 *
 */
@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService{
	
	private DetalleFacturaProductoRepository detalleFacturaProductoRepository;
	
	
	@Autowired
	public void setDetalleFacturaProductoRepository(
			DetalleFacturaProductoRepository detalleFacturaProductoRepository) {
		this.detalleFacturaProductoRepository = detalleFacturaProductoRepository;
	}

	//Obtiene todos los detalleFacturaProducto
	public Collection<FacturaDetalle> obtenerTodos() {
		Collection<FacturaDetalle> detalleFacturaProductos = (Collection<FacturaDetalle>) detalleFacturaProductoRepository.findAll();
		return detalleFacturaProductos;
	}

	public FacturaDetalle findOne(Long id) {
		return detalleFacturaProductoRepository.findOne(id);
	}

	public FacturaDetalle create(
			FacturaDetalle detalleFacturaProducto) {
		return detalleFacturaProductoRepository.save(detalleFacturaProducto);
	}

	public FacturaDetalle update(
			FacturaDetalle detalleFacturaProducto) {
		return detalleFacturaProductoRepository.save(detalleFacturaProducto);
	}

	public void delete(Long id) {
		detalleFacturaProductoRepository.delete(findOne(id));
	}



	
	

}
