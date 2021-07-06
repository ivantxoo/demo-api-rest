package com.example.restservice;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restservice.dto.Evento;
import com.example.restservice.service.DemoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
class DemoControllerTests {
	
	@Autowired
    private DemoService service;
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoControllerTests.class);
	
	@Test
	void findByIdFuenteTestReturnEventosList() throws Exception {
		List<Evento> eventos = service.findByIdFuente(1L);
		assertThat(eventos, not(empty()));
		showLogJson(eventos);
	}

	@Test
	void findByTimestampsTestFindObjects() throws Exception {
		List<Long> timestamps = new ArrayList<Long>(Arrays.asList(1625597347L,1625597345L));
		List<Evento> eventos = service.findByTimestamps(timestamps);
		
		assertThat(eventos, not(empty()));
		eventos.stream()
        .forEach(i -> {
            assertThat(i.getId(), notNullValue());
        });
		showLogJson(eventos);
	}

	
	@Test
	void findByValueRangeTestReturnEventosList() throws Exception {
		List<Evento> eventos = service.findByValueRange(50L, 1L);
		assertThat(eventos, not(empty()));
		showLogJson(eventos);
	}

	@Test
	void findByValueRangeTestReturnEmptyList() throws Exception {
		List<Evento> eventos = service.findByValueRange(1L, 50L);
		assertThat(eventos, (empty()));
	}
	
	private void showLogJson(List<Evento> eventos) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(eventos);
		LOGGER.info(json);
	}


}
