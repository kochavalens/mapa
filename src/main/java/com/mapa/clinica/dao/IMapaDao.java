package com.mapa.clinica.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mapa.clinica.models.Mapa;


public interface IMapaDao extends CrudRepository<Mapa, String>{
	
	@Query(value = "select * from mapa " + "where codigo_prestacion LIKE %?1% "
			+ "OR (prestacion LIKE %?1%) " + "OR (torre Like %?1%) " + "OR (piso LIKE %?1%) ", nativeQuery = true)
	Slice<Mapa> searchByTextMapa(Pageable pageable, String searchText);

}
