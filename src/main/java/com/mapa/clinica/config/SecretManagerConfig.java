package com.mapa.clinica.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SecretManagerConfig {
	private static Logger log = LoggerFactory.getLogger(SecretManagerConfig.class);

	@Value("${secret.manager.telemedicine}")
	String secretManagerTelemedicine;
	
	@Bean
	public String secret() {
		//log.info("secret"+secretManagerTelemedicine);
		SecretManagerConfigImpl secretManagerConfigImpl =  new SecretManagerConfigImpl();
		secretManagerConfigImpl.secretManager = secretManagerTelemedicine;
		
		return secretManagerTelemedicine;
	}
	
	
	
	
	
	
}

