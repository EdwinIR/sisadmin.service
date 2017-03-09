package com.sisadmin.service.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.Menu;
import com.sisadmin.repository.MenuRepository;



@Service
public class MenuService {

	
	@Autowired
	private MenuRepository menuRepository;
	
	    
    public Menu findOne(String id){
    	return menuRepository.findOne(id);
    }
	
    public List<Menu> findAll(){
    	return (List<Menu>)menuRepository.findAll();
    }
	
    public List<Menu> findByCodPadre(String codOpcionMenuPadre){
    	return (List<Menu>)menuRepository.findByCodPadre(codOpcionMenuPadre);
    }
    
}
