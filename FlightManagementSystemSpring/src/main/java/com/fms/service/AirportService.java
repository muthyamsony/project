package com.fms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.entities.Airport;
import com.fms.repository.AirportRepository;
@Service
public class AirportService 
{
	@Autowired
	AirportRepository adao;
	public void setAdao(AirportRepository adao) { this.adao=adao;}
	
	@Transactional(readOnly=true)
	public Airport viewAirport(String airportcode)
	{
		return adao.findById(airportcode).get();
	}
	

	@Transactional(readOnly=true)
	public List<Airport> viewAirport()
	{
		return adao.findAll();
	}
	
	@Transactional
	public Airport addAirport(Airport airport)
	{
		return adao.save(airport);
		
	}
	

	@Transactional
	public Airport modifyAirport(Airport airport)
	{
		Airport a = adao.findById(airport.getAirportCode()).get();
		if(a!=null) {
		a.setAirportName(airport.getAirportName());
		a.setAirportLocation(airport.getAirportLocation());
		}
		return a;
	}
	
	@Transactional
	public void deleteAirport(String airportId)
	{
		adao.deleteById(airportId);
	}	
	
	@Transactional
	public Airport getAirport(String airportName)
	{
		Airport air=adao.findByairportName(airportName);
		return air;
	}
}
