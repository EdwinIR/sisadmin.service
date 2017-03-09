package com.sisadmin.service.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.TablaGeneral;
import com.sisadmin.repository.TablaGeneralRepository;


@Service
public class TablaGeneralService {

	@Autowired
	protected TablaGeneralRepository generalRepository;
	
	public List<TablaGeneral> findByCodTabla(String cod_table){
				return generalRepository.findByCodTabla(cod_table);
	}
	
}
