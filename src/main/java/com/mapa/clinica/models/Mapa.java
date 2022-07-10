package com.mapa.clinica.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mapa")
public class Mapa {

	@Id
	private String id;
	private String codigo_prestacion;
	private String prestacion;
	private String torre;
	private String piso;

	public Mapa() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo_prestacion() {
		return codigo_prestacion;
	}

	public void setCodigo_prestacion(String codigo_prestacion) {
		this.codigo_prestacion = codigo_prestacion;
	}

	public String getPrestacion() {
		return prestacion;
	}

	public void setPrestacion(String prestacion) {
		this.prestacion = prestacion;
	}

	public String getTorre() {
		return torre;
	}

	public void setTorre(String torre) {
		this.torre = torre;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	@Override
	public String toString() {
		return "Mapa [id=" + id + ", codigo_prestacion=" + codigo_prestacion + ", prestacion=" + prestacion + ", torre="
				+ torre + ", piso=" + piso + "]";
	}

}
