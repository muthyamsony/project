package com.fms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.entities.Passenger;
import com.fms.repository.PassengerRepository;
@Service
public class PassengerService 
{
     @Autowired
     PassengerRepository pdao;
     
     
     @Transactional(readOnly=true)
     public Passenger viewPassenger(int bookingid)
     {
    	 return pdao.findById(bookingid).get();
     }
     
     @Transactional(readOnly=true)
     public List<Passenger> viewPassenger()
     {
    	 return pdao.findAll();
     }
     
     @Transactional
     public Passenger addPassenger(Passenger passenger)
     {
    	Passenger p= pdao.save(passenger);
    	return p;
     }
     
     @Transactional
     public Passenger modifyPassenger(Passenger passenger)
     {
    	Passenger p= pdao.save(passenger);
    	return p;
     }
     
     @Transactional
     public void deletePassenger(int bookingid)
     {
    	 pdao.deleteById(bookingid);
     }
}
