package com.sisadmin.service.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.TransDeposito;
import com.sisadmin.repository.TransDepositoRepository;

@Service
public class TransDepositoImpl implements TransDepositoService{

	private TransDepositoRepository transDepositoRepository;
	
	@Autowired
	public void setTransDepositoRepository(TransDepositoRepository transDepositoRepository){
		this.transDepositoRepository = transDepositoRepository;
	}
	
	public Collection<TransDeposito> obtenerTodos() {
		return (Collection<TransDeposito>) transDepositoRepository.findAll();
	}

	public TransDeposito findOne(Long id) {
		return transDepositoRepository.findOne(id);
	}

	public TransDeposito create(TransDeposito transDeposito) {
		return transDepositoRepository.save(transDeposito);
	}

	public TransDeposito update(TransDeposito transDeposito) {
		return transDepositoRepository.save(transDeposito);
	}

	public void delete(Long id) {
		transDepositoRepository.delete(id);		
	}

}
