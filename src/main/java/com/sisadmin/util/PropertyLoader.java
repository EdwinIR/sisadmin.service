package com.sisadmin.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class PropertyLoader {

		
		private static final Properties services;
		
		
		static {
		        try {
			        	InputStream io = null;
			    		String context = System.getProperty("sisadmin.context");
			    		int tamanho = context.length();
			    		char caracter = context.charAt(tamanho - 1);
			    		if(caracter == '\\' || caracter == '/') {
		
								services = new Properties();
					        	io = new FileInputStream(System.getProperty("sisadmin.context")+"services.properties");
					        	services.load(io);	    
								
			    		} else {
		
								services = new Properties();
					        	io = new FileInputStream(System.getProperty("sisadmin.context") + "/" + "services.properties");
					        	services.load(io);	    
								
			    		}
		        
		        } catch (Throwable ex) {
		            		System.err.println("Initial SessionFactory creation failed." + ex);
		            		throw new ExceptionInInitializerError(ex);
		        }   
	    }
	  


	    public static Properties getServicesProperties() { return services; }	



	
	
	
	
	
	

  
	
}


