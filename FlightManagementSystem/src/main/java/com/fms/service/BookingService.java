package com.fms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fms.entities.Airport;
import com.fms.entities.Booking;
import com.fms.entities.Passenger;
import com.fms.repository.BookingRepository;
@Service
public class BookingService 
{
	@Autowired
	BookingRepository bookingDao;
	PassengerService passengerService;
	public void setBookingDao(BookingRepository bookingDao) 
	{
		this.bookingDao = bookingDao;
	}
	
	@Transactional(readOnly=true)
    public Booking viewBooking(int bookingId)
    {
    	return bookingDao.findById(bookingId).get();
    }
	
	@Transactional(readOnly=true)
    public List<Booking> viewBooking()
    {
    	return bookingDao.findAll();
    }

	@Transactional
    public Booking addBooking(Booking booking)
    {
		 //for(Passenger p : booking.getPassenger())
    	//	 passengerService.addPassenger(p);
    	return bookingDao.save(booking);
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
    public void deleteBooking(int bookingId)
    {
    	bookingDao.deleteById(bookingId);
    }
}
