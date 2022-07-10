package com.mapa.clinica.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapa.clinica.models.Mapa;
import com.mapa.clinica.services.IMapaService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS,
		RequestMethod.HEAD })
@RestController
@RequestMapping({ "/api" })
public class MapaController {

	private static Logger log = LoggerFactory.getLogger(MapaController.class);

	@Value("${secret.manager.telemedicine}")
	String secretManagerTelemedicine;
	
	@Autowired
	IMapaService imapaservice;
	
	@GetMapping("/mapa")
	public List<Mapa> getMapaClinica() {
		return imapaservice.getAll();
	}
	
	@PostMapping("/mapa/getAllBySearchTextMapa")
	public Slice<Mapa> getAllBySearchTextMapa(@RequestParam(value = "pageIndex") String pageIndex,
			@RequestParam(value = "pageSize") String pageSize, @RequestParam(value = "searchText") String searchText) {
		Slice<Mapa> response = null;
		response = imapaservice.searchByTextMapa(
				PageRequest.of(Integer.parseInt(pageIndex), Integer.parseInt(pageSize)), searchText);
		return response;
	}
}
