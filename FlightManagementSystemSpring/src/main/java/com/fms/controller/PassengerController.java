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

import com.fms.entities.Passenger;
import com.fms.entities.Userdata;
import com.fms.service.PassengerService;
import com.fms.service.UserService;

@RestController
@RequestMapping("/passenger")
@CrossOrigin("http://localhost:4200")
public class PassengerController {
	 @Autowired
     PassengerService passengerservice;
	  @GetMapping(value="/getPassenger/{bookingid}",produces="application/json")
	     public Passenger getPassenger(@PathVariable int bookingid)
	     {
	    	 return passengerservice.viewPassenger(bookingid);
	     }
	     
	     @PostMapping(value="/addPassenger/{bid}")
	     public String addPassenger(@RequestBody List<Passenger> p, @PathVariable String bid)
	     {
	    	 System.out.println(p);
	    	List<Passenger>  u= passengerservice.addPassenger(p,bid);
	    	return "booking done successfully";
	    	 
	     }
	     
	     @GetMapping(value="/getAllPassenger",produces="application/json")
	     public List<Passenger> viewPassenger()
	     {
	    	 return passengerservice.viewPassenger();
	     }
	     
	     @DeleteMapping("/deletePassenger/{passengeruin}")
	     public String deletePassenger(@PathVariable int passengeruin)
	     {
	    	 passengerservice.deletePassenger(passengeruin);
	    	 return "User Details Deleted";
	     }
	     
	     @PutMapping("/updatePassenger")
	     public Passenger updateUser(@RequestBody Passenger p)
	     {
	    	 Passenger u=passengerservice.modifyPassenger(p);
	    	 return u;
	     }
}
