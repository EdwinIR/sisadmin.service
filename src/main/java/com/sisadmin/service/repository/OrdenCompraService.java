package com.sisadmin.service.repository;

import java.util.Collection;

import com.sisadmin.entity.OrdenCompraDetalle;
/**
 * DetalleOrdenCompraService
 * @author ciro
 *
 */
public interface OrdenCompraService {

	Collection<OrdenCompraDetalle> obtenerTodos();
	OrdenCompraDetalle findOne(Long id);
	OrdenCompraDetalle create(OrdenCompraDetalle detalleOrdenCompra);
	OrdenCompraDetalle update(OrdenCompraDetalle detalleOrdenCompra);
	void delete(Long id);
}
