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
import com.fms.repository.ScheduledFlightRepository;
@Service
public class ScheduledFlightService 
{
    @Autowired
    ScheduledFlightRepository fsdao;
   
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
    public Scheduledflight addScheduledFlight(Scheduledflight sf)
    {
    	
    	 return fsdao.save(sf);
    }
    
    @Transactional
    public Scheduledflight modifyScheduledFlight( Scheduledflight sf)
    {
    	Scheduledflight fs=fsdao.findById(sf.getScheduledflightid()).get();
    	if(fs!=null)
    	{
    		fs.setScheduledflightid(sf.getScheduledflightid());
    		fs.setAvailableSeats(sf.getAvailableSeats());
    		fs.setTicketcost(sf.getTicketcost());
    		fs.setFlight(sf.getFlight());
    		fs.setSourceairport(sf.getSourceairport());
    		fs.setDestinationairport(sf.getDestinationairport());
    		fs.setArrivaltime(sf.getArrivaltime());
    		fs.setDeparturetime(sf.getDeparturetime());
    	}
    	return fsdao.save(fs);
    
    }
    
    @Transactional
    public void deleteScheduledFlight(int scheduleId)
    {
    	  fsdao.deleteById(scheduleId);
    }
    
    @Transactional
    public Scheduledflight viewScheduledFlight(Airport source, Airport destination, Date date)
    {
    	Scheduledflight sf=fsdao.findByAirport(source,destination,date);
    	return sf;
    }
}
