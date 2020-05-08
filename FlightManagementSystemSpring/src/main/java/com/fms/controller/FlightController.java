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

import com.fms.entities.Flight;
import com.fms.exceptions.IdNotFoundException;
import com.fms.service.FlightService;


@RestController
@RequestMapping("/flight")
@CrossOrigin("http://localhost:4200")
public class FlightController {
	 @Autowired
     FlightService flightservice;

	public void setFlightservice(FlightService flightservice) {
		this.flightservice = flightservice;
	}

	@GetMapping(value="/getflight/{flightnumber}",produces="application/json")
	     public Flight viewFlight(@PathVariable int flightnumber)
	     {
	    	 return flightservice.viewFlight(flightnumber);
	     }
	     
	     @PostMapping(value="/addflight")
	     public ResponseEntity<String> addFlight(@RequestBody Flight flight)
	     {
	    	 Flight f= flightservice.addFlight(flight);
	    		if (f == null) {
	    			throw new IdNotFoundException("Enter Valid Id");
	    		} else {
	    			return new ResponseEntity<String>("flight details added successfully", new HttpHeaders(), HttpStatus.OK);
	    		}
	     }
	     
	     @GetMapping(value="/getAllFlight",produces="application/json")
	     public List<Flight> viewFlight()
	     {
	    	 return flightservice.viewFlight();
	     }
	     
	     @DeleteMapping("/deleteFlight/{flightnumber}")
	     public String deleteFlight(@PathVariable int flightnumber)
	     {
	    	 flightservice.deleteFlight(flightnumber);
	    	 return "Flight Details Deleted";
	     }
	     
	     @PutMapping("/updateFlight")
	     public ResponseEntity<String> modifyFlight(@RequestBody Flight flight)
	     {
	    	 Flight f=flightservice.modifyFlight(flight);
	    		if (f == null) {
	    			throw new IdNotFoundException("Enter Valid Id");
	    		} else {
	    			return new ResponseEntity<String>("flight details modified successfully", new HttpHeaders(), HttpStatus.OK);
	    		}
	     }
}
