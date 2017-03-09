package com.sisadmin.service.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.Emisor;
import com.sisadmin.repository.EmisorRepository;

@Service
public class EmisorService {

	
	@Autowired
	public EmisorRepository emisorRepository;
	
    public Emisor save(Emisor emitter){
    	return emisorRepository.save(emitter);
    }
    
    public void delete(Long id){
    	emisorRepository.delete(id);
    }

    public Emisor findOne(Long id){
    	return emisorRepository.findOne(id);
    }
	
    public List<Emisor> findAll(){
    	return (List<Emisor>)emisorRepository.findAll();
    }
	public Emisor findOneByIdentification(String identification){
    	return emisorRepository.findOneByRuc(identification);
    }
}
