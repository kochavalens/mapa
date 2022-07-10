package com.mapa.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.mapa.clinica.dao.IMapaDao;
import com.mapa.clinica.models.Mapa;

@Service
public class MapaServiceImpl implements IMapaService {
	
	@Autowired
	IMapaDao imapadao;
	
	public List<Mapa> getAll() {
		return (List<Mapa>) imapadao.findAll();
	}
	
	@Override
	public Slice<Mapa> searchByTextMapa(PageRequest pageIndex, String text) {
		return (Slice<Mapa>) imapadao.searchByTextMapa(pageIndex, text);
	}

}
