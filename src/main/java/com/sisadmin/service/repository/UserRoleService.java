package com.sisadmin.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.UserRole;
import com.sisadmin.entity.UserRolePK;
import com.sisadmin.repository.UserRoleRepository;



@Service
public class UserRoleService {
	
	@Autowired
	protected UserRoleRepository userRoleRepository;
	
	public void save(UserRole userRole){
		userRoleRepository.save(userRole);
	}
	
	public UserRole findOne(UserRolePK userRolePK){
	    	return userRoleRepository.findOne(userRolePK);
	}
	
	public void delete(UserRole userRole){
				userRoleRepository.delete(userRole);
	}
	
	public UserRole findByRucAndCodUsuarioAndIsActive(String ruc, String codigo, String active){
		return userRoleRepository.findByRucAndCodUsuarioAndIsActive(ruc, codigo, active);
	}
	
	
	public UserRole findByRucAndCodUsuario(String ruc, String codigo){
		return userRoleRepository.findByRucAndCodUsuario(ruc, codigo);
	}
		

}
