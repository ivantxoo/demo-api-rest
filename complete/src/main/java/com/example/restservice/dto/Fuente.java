package com.example.restservice.dto;

import java.util.List;

public class Fuente {

	private Long id;
	private String nombre;
	private List<Evento> eventos;
	
//	public Fuente(long id, String nombre) {
//		this.id = id;
//		this.nombre = nombre;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	
}
