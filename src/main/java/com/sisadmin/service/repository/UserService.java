package com.sisadmin.service.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisadmin.entity.User;
import com.sisadmin.entity.UserPK;
import com.sisadmin.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	protected UserRepository userRepository;
	
	public void save(User user){
			userRepository.save(user);
	}
	
	public User findOne(UserPK id){
	    	return userRepository.findOne(id);
	}
		
	public List<User> findAll(){
	    	return (List<User>)userRepository.findAll();
	}
	
	public void delete(User user){
		userRepository.delete(user);
	}
	
	public User findByRucAndCodUsuarioAndTipoUsuario(String Ruc, String Codusuario, String TipoUsuario){
		return userRepository.findByRucAndCodUsuarioAndTipoUsuario(Ruc, Codusuario, TipoUsuario);
	}
	
	public User findByRucAndCodUsuario(String Ruc, String Codusuario){
		return userRepository.findByRucAndCodUsuario(Ruc, Codusuario);
	}
	
	public List<User> findAllByRuc(String Ruc){
		return userRepository.findAllByRuc(Ruc);
	}
	
	public List<User> findAllBytipoUsuario(String tipoUsuario){
		return userRepository.findAllBytipoUsuario(tipoUsuario);
	}
	
}
