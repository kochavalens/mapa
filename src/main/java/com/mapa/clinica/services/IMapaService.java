package com.mapa.clinica.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import com.mapa.clinica.models.Mapa;

public interface IMapaService {
	
	public List<Mapa> getAll();
	public Slice<Mapa> searchByTextMapa(PageRequest pageIndex, String searchText);

}
