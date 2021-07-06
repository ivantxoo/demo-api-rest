package com.example.restservice.dto;

import java.util.Date;

public class Evento {

	private Long id;
	private Long fuenteId;
	private Long timestamp;
	private Long valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFuenteId() {
		return fuenteId;
	}
	public void setFuenteId(Long fuenteId) {
		this.fuenteId = fuenteId;
	}
	public Long getValor() {
		return valor;
	}
	public void setValor(Long valor) {
		this.valor = valor;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}


}
