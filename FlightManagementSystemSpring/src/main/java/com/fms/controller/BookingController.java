package com.fms.controller;
import java.time.LocalDate;
import java.util.ArrayList;
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

import com.fms.entities.Booking;
import com.fms.entities.Passenger;
import com.fms.service.BookingService;
import com.fms.service.PassengerService;
@RestController
@RequestMapping("/booking")
@CrossOrigin("http://localhost:4200")
public class BookingController 
{
     @Autowired
     BookingService bookingService;
     public void setBookingService(BookingService bookingService) {this.bookingService=bookingService;}
     
     @Autowired
     PassengerService passengersService;
     public void setPdao(PassengerService passengersService) { this.passengersService=passengersService; }
     
    /* @GetMapping("/addBooking")
     public String addBookingDetails()
     {
    	 Users user = new Users();   user.setUsername("venu");
    	 FlightSchedule sched = new FlightSchedule(); sched.setScheduleId("a101");
    	 ArrayList<Passengers> plist = new ArrayList<>();
    	 Passengers p1 = new Passengers("p8001","Ajay",25,'M',"ajay@gmail.com",9999999999L,"3A");
    	 Passengers p2 = new Passengers("p8002","Eashwar",30,'M',"Eashwar@gmail.com",8888888888L,"3B");
    	 passengersService.addPassengers(p1);   passengersService.addPassengers(p2);
    	 plist.add(p1);   plist.add(p2);
    	 Booking booking = new Booking("B7001",user,sched,LocalDate.now(),LocalDate.now(),plist);
    	 bookingService.addBookingDetails(booking);
    	 return "Hello From Booking";
     }*/
     
     @GetMapping(value="/getBooking/{bookingId}",produces="application/json")
     public Booking viewBooking(@PathVariable String bookingId)
     {
    	 return bookingService.viewBooking(bookingId);
     }
     
     @PostMapping(value="/addBooking/{username}/{scheduledflightid}")
     public void addBookingDetails(@RequestBody Booking booking,@PathVariable String username, @PathVariable int scheduledflightid)
     {
    //	System.out.println(booking);
//    	 for(Passenger p : booking.getPassenger())
// 			passengersService.addPassenger(p);
 		Booking b=bookingService.addBooking(booking,username,scheduledflightid);
    	 
     }
     
     @GetMapping(value="/getAllBookings",produces="application/json")
     public List<Booking> viewBooking()
     {
    	 return bookingService.viewBooking();
     }
     
     @DeleteMapping("/deleteBooking/{bookingId}")
     public String deleteBooking(@PathVariable String bookingId)
     {
    	 bookingService.deleteBooking(bookingId);
    	 return "This booking record is deleted";
     }
     
     @PutMapping("/updateBooking")
     public Booking updateBooking(@RequestBody Booking booking)
     {
    	Booking b= bookingService.modifyBooking(booking);
    	return b;
     }
     @GetMapping(value="/getBookingid",produces="application/json")
     public String getbookingid()
     {
    	 return bookingService.getbookingid();
     }
     @GetMapping(value="/getbooking/{username}",produces="application/json")
     public List<Booking> getbooking(@PathVariable String username)
     {
    	 List<Booking> booking=bookingService.getbooking(username);
    	 return booking;
     }
}
