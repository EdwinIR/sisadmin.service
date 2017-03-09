package com.sisadmin.service.repository;

import java.util.Collection;

import com.sisadmin.entity.TransDepositoDetalle;



public interface TransDepositoDetalleService {

	Collection<TransDepositoDetalle> obtenerTodos();
	TransDepositoDetalle findOne(Long id);
	TransDepositoDetalle create(TransDepositoDetalle detalleTransDepositoDetalle);
	TransDepositoDetalle update(TransDepositoDetalle detalleTransDepositoDetalle);
	void delete(Long id);
}
