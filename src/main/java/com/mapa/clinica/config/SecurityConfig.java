package com.mapa.clinica.config;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import com.mapa.clinica.util.SecretManagerUtils;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static Logger log = LoggerFactory.getLogger(SecurityConfig.class);
	@Value("${secret.manager.gcp.library.telemedicine}")
	private String secretTelemedicine;

	@Value("${secret.manager.telemedicine}")
	String secretManagerTelemedicine;

	private SecretManagerUtils secretManagerUtils = new SecretManagerUtils();

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        log.info("header");
//        http.cors().and().authorizeRequests();
//
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/api/**").permitAll()
//                .antMatchers("/api/listReportSendSengrid","/api/landingMaintainer/**").authenticated().and()
//                .oauth2ResourceServer()
//                .jwt()
//                .and()
//                .authenticationEntryPoint(new Http403ForbiddenEntryPoint());
//
//    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests();

		http.csrf().disable().authorizeRequests()				
				.antMatchers("/api/fileAttachment/getFileAttachment").authenticated().and().httpBasic();
		
		//.antMatchers("/actuator/**","/api/fileAttachment/UploadFileToLanding").permitAll()
		// .and().authorizeRequests().antMatchers("/api/**").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		JSONObject credentials = new JSONObject(secretManagerTelemedicine).getJSONObject("service-credentials");
		JSONObject serviceCredentials = credentials.getJSONObject("ms-file-attachment");
		String user = serviceCredentials.getString("user");
		String passwordSecret = serviceCredentials.getString("password");
		String password = String.format("{noop}%s", passwordSecret);

		auth.inMemoryAuthentication().withUser(user).password(password).roles("USER");
	}
}
