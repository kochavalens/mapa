package com.mapa.clinica.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataSourceConfig {
	
	private static Logger log = LoggerFactory.getLogger(DataSourceConfig.class);
    @Value("${secret.manager.telemedicine}")
    String secretManagerTelemedicine;


    @Value("${spring.profiles.active:}")
    private String activeProfile;
  
    @Bean
    public DataSource getDataSource() throws JSONException {

        JSONObject obj = new JSONObject(secretManagerTelemedicine);
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");

        /*TODO validacion de environment*/
//        log.info("ENVIRONMENT "+activeProfile);
//        log.info("ENVIRONMENT act  "+activeProfile.equals("local"));
//        log.info(" secretManagerTelemedicine ENVIRONMENT "+secretManagerTelemedicine);

       if(activeProfile.equals("local")){
           ///dataSourceBuilder.url("jdbc:mysql://localhost:5000/telemed");
    	   dataSourceBuilder.url(obj.getJSONObject("database").getString("url"));
        }else {
           dataSourceBuilder.url(obj.getJSONObject("database").getString("url"));
        }
        dataSourceBuilder.username(obj.getJSONObject("database").getString("username"));
        dataSourceBuilder.password(obj.getJSONObject("database").getString("password"));

        return dataSourceBuilder.build();
    }
}

