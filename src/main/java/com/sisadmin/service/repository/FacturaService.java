package com.sisadmin.service.repository;

import java.util.Collection;

import com.sisadmin.entity.FacturaDetalle;
import com.sisadmin.entity.Factura;

public interface FacturaService {
	
	Collection<Factura> obtenerTodos();
	Factura findOne(Long id);
	Factura create(Factura factura);
	Factura update(Factura factura);
	void delete(Long id);

}
