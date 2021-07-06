package com.example.restservice.service;

import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.restservice.dto.Evento;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class DemoServiceImpl implements DemoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);
	private static final String FILE_NAME = "demoDataEvento.json";
	
	@Override
	public List<Evento> findByIdFuente(Long id) throws ServerException {
		
		List<Evento> allEventos = getEventosFromFile();
		
		return  allEventos.stream().filter(o -> o.getFuenteId().equals(id)).collect(toList());

	}

	@Override
	public List<Evento> findByTimestamps(List<Long> timestamps) throws ServerException {
		
		List<Evento> allEventos = getEventosFromFile();
		List<Evento> eventos = new ArrayList<>();
		
		for (Long timestamp : timestamps) {
			eventos.addAll(allEventos.stream().filter(o -> o.getTimestamp().compareTo(timestamp)==0).collect(toList()));
		}
		return  eventos;
	}
	

	@Override
	public List<Evento> findByValueRange(Long maxValue, Long minValue) throws ServerException {
		
		List<Evento> allEventos = getEventosFromFile();
		
		return allEventos.stream().filter(o -> (o.getValor()>minValue && o.getValor()<maxValue)).collect(toList());
	}
	
	
	private List<Evento> getEventosFromFile() throws ServerException {
		
		URL url = this.getClass().getClassLoader().getResource(FILE_NAME);
		
		File file = null;
		if(url != null) {
			file = new File(url.getFile());
		} else {
			throw new ServerException("File not found error");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		List<Evento> allEventos = null;
		try {
			allEventos = mapper.readValue(file, new TypeReference<List<Evento>>(){});
		} catch (IOException e) {
			LOGGER.error("json reading error", e);
			throw new ServerException("File parser error", e);
		}
		return allEventos;
	}
}