package com.example.restservice.service;

import java.rmi.ServerException;
import java.util.List;

import com.example.restservice.dto.Evento;

public interface DemoService {

    /**
     * This method find Evento list by idFuente
     * @param id idFuente
     * @return list of Evento for this idFuente
     * @throws ServerException server file processing exception 
     */
    public List<Evento> findByIdFuente(Long id) throws ServerException;

	/**
	 * This method find Evento list by timestamp list
	 * @param timestamps
	 * @return list of Evento for this timestamps
	 * @throws ServerException server file processing exception
	 */
	public List<Evento> findByTimestamps(List<Long> timestamps) throws ServerException;

	/**
	 * This method find Evento list between maxValue and minValue
	 * @param maxValue max limit value
	 * @param minValue min limit value
	 * @return list of Evento for this interval
	 * @throws ServerException server file processing exception 
	 */
	public List<Evento> findByValueRange(Long maxValue, Long minValue) throws ServerException;

}