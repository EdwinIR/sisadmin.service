package com.sisadmin.service.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.RoleMenu;
import com.sisadmin.repository.RoleMenuRepository;



@Service
public class RoleMenuService {

	@Autowired
	protected RoleMenuRepository roleMenuRepository;
	
	 public List<RoleMenu> findByCodRoleMenu(String codRolMenu){
		 return roleMenuRepository.findByCodRoleMenu(codRolMenu);
	 }
	
	 public void save(List<RoleMenu> roleMenu){
		 roleMenuRepository.save(roleMenu);
	 }
	 
	 public void delete(List<RoleMenu> roleMenu){
		 roleMenuRepository.delete(roleMenu);
	 }


}
