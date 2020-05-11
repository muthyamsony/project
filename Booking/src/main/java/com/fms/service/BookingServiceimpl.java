package com.fms.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Booking;
import com.fms.dto.Scheduledflight;
import com.fms.dto.Userdata;
import com.fms.dto.Airport;
import com.fms.dto.Passenger;
import com.fms.exception.IdNotFoundException;
import com.fms.repository.AirportRepository;
import com.fms.repository.BookingRepository;
import com.fms.repository.PassengerRepository;
import com.fms.repository.ScheduledflightRepository;
import com.fms.repository.UserRepository;

@Service
public class BookingServiceimpl implements Bookingservice {

	@Autowired
	ScheduledflightRepository sfdao;
	
	@Autowired
	BookingRepository bdao;
	
	@Autowired
	PassengerRepository pdao;
	
	@Autowired
	UserRepository udao;
	
	@Autowired
	AirportRepository adao;
	
	@Transactional
	public List<Scheduledflight> viewScheduledflight() {
		List<Scheduledflight> flights= sfdao.findAll();
		return flights;
		
	}
	@Transactional
	public List<Scheduledflight> availableflights(String source,String destination, String date1) {
		System.out.println(source+" "+destination+" "+date1);
		List<Scheduledflight> flights1=sfdao.availableflights(source,destination,date1);
		return flights1;
	}
	@Transactional
	public String updateSeats(Scheduledflight flight,Booking book) {
        
			sfdao.save(flight);
			return "seats were updated successfully!!";
	
	}
	@Transactional
	 public Booking addBooking(Booking booking, String username, int scheduledflightid)
	    {
		Scheduledflight sf=sfdao.findById(scheduledflightid).get();
		Userdata ud=udao.findById(username).get();
		if(sf==null||ud==null)
			return null;
		if(booking.getScheduledflight()==null || booking.getUsername()==null)
		{
			Booking b=bdao.save(booking);
			b.setScheduledflight(sf);
			List<Booking> book=new ArrayList<Booking>();
			book.add(b);
			ud.setBooking(book);
			return b;
			
		}
		else throw new IdNotFoundException("Invalid booking details");
	     
	    }

@Transactional
public Booking modifyBooking(Booking booking)
   {
    return  bdao.save(booking);
	}

@Transactional
public List<Booking> viewBooking() {
	List<Booking> list= bdao.findAll();
	return list;
}
	@Transactional
	public Booking viewBooking(String bookingId) {
		Booking booking= bdao.findById(bookingId).get();
		return booking;
	}
	
	@Transactional
	public void deleteBooking(String bookingid)
	{
		bdao.deleteById(bookingid);
	}
	
	@Transactional
	public String getbookingid()
	{
	long min=100000000;
	long max=999999999;
    long x = (long) ((Math.random()*((max-min)+1))+min);
    String random=Long.toString(x);
    return random;
	}
	
	  @Transactional
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
	     public void deletePassenger(int bookingid)
	     {
	    	 pdao.deleteById(bookingid);
	     }
		@Transactional
		public Userdata viewUser(String username) {
			Userdata ud=udao.findById(username).get();
			return ud;
		}
		
		@Transactional
		public List<Airport> viewAirport()
		{
			return adao.findAll();
		}
		
		@Transactional
	    public List<Booking> getbooking(String username)
	    {
			List<Booking> booking=bdao.findBybooking(username);
			return booking;
	    }
	     
}
