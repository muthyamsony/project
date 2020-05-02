package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fms.service.AirportService;


@RestController
@RequestMapping("/airport")
@CrossOrigin("http://localhost:4200")
public class AirportController {
	 @Autowired
     AirportService airportservice;
	  @GetMapping(value="/getAirport/{airportcode}",produces="application/json")
	     public Airport viewAirport(@PathVariable String airportcode)
	     {
	    	 return airportservice.viewAirport(airportcode);
	     }
	     
	     @PostMapping(value="/addAirport")
	     public Airport addAirport(@RequestBody Airport airport)
	     {
	    	 Airport  a= airportservice.addAirport(airport);
	    	 return a;
	     }
	     
	     @GetMapping(value="/getAllAirports",produces="application/json")
	     public List<Airport> viewAirport()
	     {
	    	 return airportservice.viewAirport();
	     }
	     
	     @DeleteMapping("/deleteAirport/{airportcode}")
	     public String deleteAirport(@PathVariable String airportcode)
	     {
	    	 airportservice.deleteAirport(airportcode);
	    	 return "User Details Deleted";
	     }
	     
	     @PutMapping("/updateAirport")
	     public Airport modifyAirport(@RequestBody Airport airport)
	     {
	    	 Airport a=airportservice.modifyAirport(airport);
	    	 return a;
	     }
}
