package com.sisadmin.service.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sisadmin.entity.Emisor;



@Component
public class EmisorActual {

	@Autowired
	private EmisorService emisorService;
	
	@Value("${sisfe.emitterId}")
	public  String GlobalId;
	
	@Value("${sisfe.path.guide}")
	public  String guidePath;

	private static Emisor emisor;
	
	public EmisorActual(){
	}
	
	public static Emisor getEmisorActual(){
		return emisor;
	}
	
	@PostConstruct	
	public void archiver(){			
		emisor = emisorService.findOneByIdentification(GlobalId);
	}

	
}

