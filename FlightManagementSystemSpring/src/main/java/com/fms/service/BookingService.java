package com.fms.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.entities.Airport;
import com.fms.entities.Booking;
import com.fms.entities.Passenger;
import com.fms.entities.Scheduledflight;
import com.fms.entities.Userdata;
import com.fms.exceptions.IdNotFoundException;
import com.fms.repository.BookingRepository;
import com.fms.repository.ScheduledFlightRepository;
import com.fms.repository.UserRepository;
@Service
public class BookingService 
{
	@Autowired
	BookingRepository bookingDao;
	
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	ScheduledFlightRepository sfdao;
	
	@Autowired
	UserRepository udao;
	
	public void setBookingDao(BookingRepository bookingDao) 
	{
		this.bookingDao = bookingDao;
	}
	
	@Transactional(readOnly=true)
    public Booking viewBooking(String bookingId)
    {
    	return bookingDao.findById(bookingId).get();
    }
	
	@Transactional(readOnly=true)
    public List<Booking> viewBooking()
    {
    	return bookingDao.findAll();
    }

	@Transactional
    public Booking addBooking(Booking booking, String username, int scheduledflightid)
    {
		 //for(Passenger p : booking.getPassenger())
    	//	 passengerService.addPassenger(p);
		Scheduledflight sf=sfdao.findById(scheduledflightid).get();
		Userdata ud=udao.findById(username).get();
		if(sf==null||ud==null)
			return null;
		if(booking.getScheduledflight()==null || booking.getUsername()==null)
		{
			Booking b=bookingDao.save(booking);
			b.setScheduledflight(sf);
			b.setUsername(ud.getUsername());
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
		Booking b = bookingDao.findById(booking.getBookingId()).get();
		if(b!=null) {
		b.setBookingDate(booking.getBookingDate());
		b.setTicketCost(booking.getTicketCost());
		b.setNoOfPassengers(booking.getNoOfPassengers());
		b.setPassenger(booking.getPassenger());
		for(Passenger p : booking.getPassenger())
   		 passengerService.modifyPassenger(p);
		}
		return bookingDao.save(b);
    }
	
	@Transactional
    public void deleteBooking(String bookingId)
    {
    	bookingDao.deleteById(bookingId);
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
    public List<Booking> getbooking(String username)
    {
		List<Booking> booking=bookingDao.findBybooking(username);
		return booking;
    }
}
