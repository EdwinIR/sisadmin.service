package com.sisadmin.service.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.Role;
import com.sisadmin.repository.RoleRepository;



@Service
public class RoleService {

	@Autowired
	protected RoleRepository roleRepository;
	
  
    public Role findOne(String id){
    	return roleRepository.findOne(id);
    }
	
    public List<Role> findAll(){
    	return (List<Role>)roleRepository.findAll();
    }
    
    
	
}
