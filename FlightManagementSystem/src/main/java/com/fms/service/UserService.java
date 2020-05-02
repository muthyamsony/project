package com.fms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.entities.Userdata;
import com.fms.repository.BookingRepository;
import com.fms.repository.UserRepository;
@Service
public class UserService
{
     @Autowired
     UserRepository udao;
 

	public void setUdao(UserRepository udao) { this.udao=udao; }
     
     @Transactional(readOnly=true)
     public Userdata viewUser(int userid)
     {
    	 return udao.findById(userid).get();
     }
     
     @Transactional(readOnly=true)
     public List<Userdata> viewUser()
     {
    	 return udao.findAll();
     }
     
     @Transactional
     public Userdata addUser(Userdata user)
     {
    	 return udao.save(user);
     }
     
     @Transactional
     public Userdata updateUser(Userdata u)
     {
    		Userdata ud=udao.findById(u.getUserid()).get();
    		if(ud!=null)
    		{
    			ud.setUsername(u.getUsername());
    			ud.setUserpassword(u.getUserpassword());
    			ud.setUserphone(u.getUserphone());
    			ud.setUseremail(u.getUseremail());
    		}
    		return udao.save(ud);
    	 
     }
     
     @Transactional
     public void deleteUser(int userid)
     {
    	  udao.deleteById(userid);
     }
    
     @Transactional
     public String LoginUser(Userdata u)
     {
    	 String flag="null";
    	
     	String usertype=udao.findByusertype(u.getUsername(),u.getUserpassword());
     	if(usertype.equalsIgnoreCase("admin"))
     			{
     				 return "admin";
     			}
     	else if(usertype.equalsIgnoreCase("customer"))
     			{
     			 return "customer";
     			}
     	else
     		 return "invalid";
     
     }
     
  
 
}
