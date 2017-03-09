package com.sisadmin.service.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.TransDepositoDetalle;
import com.sisadmin.repository.TransDepositoDetalleRepository;

@Service
public class TransDepositoDetalleImpl implements TransDepositoDetalleService{

	private TransDepositoDetalleRepository detalleTransDepositoRepository;
	
	@Autowired
	public void setDetalleTransDepositoRepository(TransDepositoDetalleRepository detalleTransDepositoRepository){
		this.detalleTransDepositoRepository = detalleTransDepositoRepository;
	}
	
	public Collection<TransDepositoDetalle> obtenerTodos() {
		Collection<TransDepositoDetalle> detalleTransDeposito = (Collection<TransDepositoDetalle>) detalleTransDepositoRepository.findAll();
		return detalleTransDeposito;
	}

	public TransDepositoDetalle findOne(Long id) {
		return detalleTransDepositoRepository.findOne(id);
	}

	public TransDepositoDetalle create(TransDepositoDetalle detalleTransDepositoDetalle) {
		return detalleTransDepositoRepository.save(detalleTransDepositoDetalle);
	}

	public TransDepositoDetalle update(
			TransDepositoDetalle detalleTransDepositoDetalle) {
		return detalleTransDepositoRepository.save(detalleTransDepositoDetalle);
	}

	public void delete(Long id) {
		detalleTransDepositoRepository.delete(id);
	}

}
