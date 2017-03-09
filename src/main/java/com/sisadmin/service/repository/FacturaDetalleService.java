package com.sisadmin.service.repository;

import java.util.Collection;
import java.util.List;

import com.sisadmin.entity.FacturaDetalle;

/**
 * 
 * @author ciro
 *
 */
public interface FacturaDetalleService {
	
	Collection<FacturaDetalle> obtenerTodos();
	FacturaDetalle findOne(Long id);
	FacturaDetalle create(FacturaDetalle detalleFacturaProducto);
	FacturaDetalle update(FacturaDetalle detalleFacturaProducto);
	void delete(Long id);

}
