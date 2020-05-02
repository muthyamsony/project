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

import com.fms.entities.Userdata;
import com.fms.exceptions.IdNotFoundException;
import com.fms.exceptions.UserNotFoundException;
import com.fms.service.UserService;
@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {
	 @Autowired
     UserService userservice;
	  @GetMapping(value="/getUser/{userid}",produces="application/json")
	     public Userdata viewUser(@PathVariable int userid)
	     {
	    	 return userservice.viewUser(userid);
	     }
	     
	     @PostMapping(value="/addUser")
	     public ResponseEntity<String> addUser(@RequestBody Userdata user)
	     {
	    	 Userdata  e= userservice.addUser(user);
	    		if (e == null) {
	    			throw new IdNotFoundException("Enter Valid Id");
	    		} else {
	    			return new ResponseEntity<String>("User created successfully", new HttpHeaders(), HttpStatus.OK);
	    		}

	    	 
	     }
	     
	     @GetMapping(value="/getAllUsers",produces="application/json")
	     public List<Userdata> viewUser()
	     {
	    	 return userservice.viewUser();
	     }
	     
	     @DeleteMapping("/deleteUser/{userid}")
	     public String deleteUser(@PathVariable int userid)
	     {
	    	 userservice.deleteUser(userid);
	    	 return "User Details Deleted";
	     }
	     
	     @PutMapping("/updateUser")
	     public Userdata updateUser(@RequestBody Userdata user)
	     {
	    	 Userdata u=userservice.updateUser(user);
	    	 return u;
	     }
	     @PutMapping("/loginUser")
	 	public String LoginUser(@RequestBody Userdata u)
	 	{
	 		
	 		 String flag=userservice.LoginUser(u);
	 		 return flag;
	 	}
	 	
}
