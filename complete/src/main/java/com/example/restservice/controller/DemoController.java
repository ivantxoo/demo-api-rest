package com.example.restservice.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.dto.Evento;
import com.example.restservice.service.DemoService;

@RequestMapping("/evento")
@RestController
public class DemoController {

	@Autowired
	DemoService service;
	
	
	@GetMapping("/byFuenteId")
	public List<Evento> findByIdFuente(@RequestParam(value = "fuente_id", required = true) Long idFuente)
			throws ServerException {
		return service.findByIdFuente(idFuente);
	}

	@GetMapping("/byTimestamps")
	public List<Evento> findByTimestamps(@RequestParam(value = "timestamps", required = true) List<Long> timestamps)
			throws ServerException {
		return service.findByTimestamps(timestamps);
	}

	@GetMapping("/byValueRange")
	public List<Evento> findByValueRange(
			@RequestParam(value = "maxValue", required = true) Long maxValue,
			@RequestParam(value = "minValue", required = true) Long minValue) throws ServerException {
		return service.findByValueRange(maxValue, minValue);
	}
	
	
}
