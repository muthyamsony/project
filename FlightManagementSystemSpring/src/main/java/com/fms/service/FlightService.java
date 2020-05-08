package com.fms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.entities.Flight;
import com.fms.repository.FlightRepository;
@Service
public class FlightService 
{
   @Autowired
   FlightRepository fdao;
   public void setFdao(FlightRepository fdao) { this.fdao=fdao; }
   
   @Transactional(readOnly=true)
   public Flight viewFlight(int flightNo)
   {
	   return fdao.findById(flightNo).get();
   }
   
   @Transactional(readOnly=true)
   public List<Flight> viewFlight()
   {
	   return fdao.findAll();
   }
   
   @Transactional
   public Flight addFlight(Flight flight)
   {
	   return fdao.save(flight);
   }
   
   @Transactional
   public Flight modifyFlight(Flight flight)
   {
	   Flight f=fdao.findById(flight.getFlightNumber()).get();
	   if(f!=null)
	   {
		   f.setCarrierName(flight.getCarrierName());
		   f.setFlightModel(flight.getFlightModel());
		   f.setSeatCapacity(flight.getSeatCapacity());
	   }
	   return fdao.save(f);
   }
   @Transactional
   public void deleteFlight(int flightNo)
   {
	   fdao.deleteById(flightNo);
   }
}
