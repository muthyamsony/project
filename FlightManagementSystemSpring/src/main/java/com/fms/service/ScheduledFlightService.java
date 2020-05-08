package com.fms.service;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.entities.Airport;
import com.fms.entities.Flight;
import com.fms.entities.Scheduledflight;
import com.fms.exceptions.IdNotFoundException;
import com.fms.repository.AirportRepository;
import com.fms.repository.FlightRepository;
import com.fms.repository.ScheduledFlightRepository;
@Service
public class ScheduledFlightService 
{
    @Autowired
    ScheduledFlightRepository fsdao;
    
    @Autowired
    FlightRepository fdao;
   
    @Autowired
    AirportService airportService;
    
    public void setFsdao(ScheduledFlightRepository fsdao) { this.fsdao=fsdao; }
    
    @Transactional(readOnly=true)
    public Scheduledflight viewScheduledFlight(int scheduledflightid)
    {
    	return fsdao.findById(scheduledflightid).get();
    }
    
    @Transactional(readOnly=true)
    public List<Scheduledflight> viewScheduledFlight()
    {
    	return fsdao.findAll();
    }
    
    @Transactional
    public Scheduledflight addScheduledFlight(Scheduledflight sf, int flightnumber, String sourceairport, String destinationairport)
    {
    	Flight f=fdao.findById(flightnumber).get();
    	Airport a=airportService.getAirport(sourceairport);
    	Airport a1=airportService.getAirport(destinationairport);
    	if(f==null||a==null||a1==null)
    		return null;
    	if(sf.getFlight()==null||sf.getSourceairport()==null||sf.getDestinationairport()==null)
    	{
    		Scheduledflight sfg=fsdao.save(sf);
    		sfg.setFlight(f);
    		sfg.setSourceairport(a);
    		sfg.setDestinationairport(a1);
    		System.out.println(sfg);
    		return sfg;
    	}
    	else throw new IdNotFoundException("flight number not found");
    }
    
    @Transactional
    public Scheduledflight modifyScheduledFlight( Scheduledflight sf, int flightnumber, String sourceairport, String destinationairport)
    {
    	Flight f=fdao.findById(flightnumber).get();
    	Airport a=airportService.getAirport(sourceairport);
    	Airport a1=airportService.getAirport(destinationairport);
    	if(f==null||a==null||a1==null)
    		return null;
    	if(sf.getFlight()==null||sf.getSourceairport()==null||sf.getDestinationairport()==null)
    	{
    		Scheduledflight sfg=fsdao.save(sf);
    		sfg.setFlight(f);
    		sfg.setSourceairport(a);
    		sfg.setDestinationairport(a1);
    		return sfg;
    	}
    	else throw new IdNotFoundException("flight number not found");
    
    }
    
    @Transactional
    public void deleteScheduledFlight(int scheduledflightid)
    {
    	  fsdao.deleteById(scheduledflightid);
    }
    
    @Transactional
    public List<Scheduledflight> viewScheduledFlight(String source,String destination)
    {
    	//Airport source=sf.getSourceairport();
    	//Airport destination=sf.getDestinationairport();
    	List<Scheduledflight> sfg=fsdao.findAllByAirport(source,destination);
    	return sfg;
    }
}
