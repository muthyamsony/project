package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entities.Airport;
import com.fms.entities.Flight;
import com.fms.entities.Scheduledflight;
import com.fms.exceptions.IdNotFoundException;
import com.fms.service.ScheduledFlightService;


@RestController
@RequestMapping("/scheduledflight")
@CrossOrigin("http://localhost:4200")
public class ScheduledFlightController {
	 @Autowired
     ScheduledFlightService sfservice;
	 
	public void setSfservice(ScheduledFlightService sfservice) {
		this.sfservice = sfservice;
	}

	@GetMapping(value="/getScheduledFlight/{scheduledid}",produces="application/json")
	     public Scheduledflight viewScheduledFlight(@PathVariable int scheduledid)
	     {
	    	 return sfservice.viewScheduledFlight(scheduledid);
	     }
	     
	     @PostMapping(value="/addScheduledFlight/{flightnumber}/{sourceairport}/{destinationairport}")
	     public ResponseEntity<String> addScheduledFlight(@RequestBody Scheduledflight sf, @PathVariable int flightnumber,@PathVariable String sourceairport, @PathVariable String destinationairport)
	     {
	    	/* Flight f1=new Flight();
	     	f1.setFlightNumber(f.getFlightNumber());
	     	Airport a1=new Airport();
	     	a1.setAirportName(a.getAirportName());
	     	Airport a2=new Airport();
	     	a2.setAirportName(a.getAirportName());
	     	Scheduledflight sfg=new Scheduledflight(sf.getScheduledflightid(),sf.getAvailableSeats(),sf.getTicketcost(),f1,a1,a2,sf.getArrivaltime(),sf.getDeparturetime());
	     	*/
	    	// System.out.println(sf);
	    	 Scheduledflight sfg1= sfservice.addScheduledFlight(sf, flightnumber,sourceairport,destinationairport);
	    		if (sfg1 == null) {
	    			throw new IdNotFoundException("Enter Valid Id");
	    		} else {
	    			return new ResponseEntity<String>("flight details added successfully", new HttpHeaders(), HttpStatus.OK);
	    		}
	     }
	     
	     @GetMapping(value="/getAllScheduledflight",produces="application/json")
	     public List<Scheduledflight> viewScheduledFlight()
	     {
	    	 return sfservice.viewScheduledFlight();
	     }
	     
	     @DeleteMapping("/deleteScheduledflight/{scheduledflightid}")
	     public String deleteScheduledFlight(@PathVariable int scheduledflightid)
	     {
	    	 sfservice.deleteScheduledFlight(scheduledflightid);
	    	 return "Scheduled flight Details Deleted";
	     }
	     
	     @PutMapping("/modifyScheduledFlight/{flightnumber}/{sourceairport}/{destinationairport}")
	     public String modifyScheduledFlight( @RequestBody Scheduledflight s,int flightnumber,String sourceairport,String destinationairport)
	     {
	    	 Scheduledflight sfg=sfservice.modifyScheduledFlight(s,flightnumber,sourceairport,destinationairport);
	    	 return "scheduled flight details updated";
	     }
	     
	     @GetMapping("/viewavailableflights/{source}/{destination}")
	     public ResponseEntity<List<Scheduledflight>> viewFlight(@PathVariable String source, @PathVariable String destination)
	     {
	    	 List<Scheduledflight> sfg=sfservice.viewScheduledFlight(source,destination);
	    		if (sfg == null) {
	    			throw new IdNotFoundException("Enter Valid Id");
	    		} else {
	    			return new ResponseEntity<List<Scheduledflight>>(sfg, new HttpHeaders(), HttpStatus.OK);
	    		}
	     }
}
