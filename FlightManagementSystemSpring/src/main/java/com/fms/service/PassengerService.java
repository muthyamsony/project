package com.fms.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.entities.Booking;
import com.fms.entities.Passenger;
import com.fms.exceptions.IdNotFoundException;
import com.fms.repository.BookingRepository;
import com.fms.repository.PassengerRepository;
@Service
public class PassengerService 
{
     @Autowired
     PassengerRepository pdao;
     
     @Autowired
     BookingRepository bdao;
     
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
     public List<Passenger> addPassenger(List<Passenger> passenger, String bookingid)
     {
    	 Booking b=bdao.findById(bookingid).get();
    	 System.out.println(bookingid);
    	 if(b==null)
    		 return null;
    	 if(b.getPassenger().isEmpty())
    	 {
    		 System.out.println(passenger);
    		 List<Passenger> p= pdao.saveAll(passenger);
    		 b.setPassenger(p);
    		 return p;
    	 }
    	 else
    		 throw new IdNotFoundException("passenger not found");
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
