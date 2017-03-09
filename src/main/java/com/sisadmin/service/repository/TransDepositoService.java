package com.sisadmin.service.repository;

import java.util.Collection;

import com.sisadmin.entity.TransDeposito;

public interface TransDepositoService {

	Collection<TransDeposito> obtenerTodos();
	TransDeposito findOne(Long id);
	TransDeposito create(TransDeposito transDeposito);
	TransDeposito update(TransDeposito transDeposito);
	void delete(Long id);
	
}
