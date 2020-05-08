package com.lvg.fms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fms.entities.Airport;
import com.fms.entities.Booking;
import com.fms.entities.Flight;
import com.fms.entities.Passenger;
import com.fms.entities.Userdata;
import com.fms.repository.AirportRepository;
import com.fms.repository.BookingRepository;
import com.fms.repository.FlightRepository;
import com.fms.repository.PassengerRepository;
import com.fms.repository.ScheduledFlightRepository;
import com.fms.repository.UserRepository;
import com.fms.service.AirportService;
import com.fms.service.BookingService;
import com.fms.service.FlightService;
import com.fms.service.PassengerService;
import com.fms.service.ScheduledFlightService;
import com.fms.service.UserService;

@SpringBootTest
@SpringBootConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
class FlightmgmtsystemApplicationTests {

	@Test
	void contextLoads() {
	}


	@Mock
	private AirportRepository adao;
	
	@InjectMocks
	private AirportService airportService;
	
	
	
	
	@Test
	public void testfindAll() {
		List<Airport> airportList=new ArrayList<>();
		airportList.add(new Airport("1","RajivGandhi","Shamshabad"));
		airportList.add(new Airport("2","Bhegumpet","Bhegumpet"));
		Mockito.when(adao.findAll()).thenReturn(airportList);
		List<Airport> result=adao.findAll();
		assertEquals(2,airportList.size());
	}
	
	
	@Test
	public void testaddAirport() {
		Airport airport=new Airport();
		airport.setAirportCode("10");
		airport.setAirportName("Rajiv");
		airport.setAirportLocation("hyd");
		adao.save(airport);
		
	}
	/*@Test
	public void testviewAirport() {
		Airport airport=new Airport("4","Rajiv","Hyd");
		Mockito.when(adao.findById(airport)).thenReturn(airport);
		Airport air=airportService.viewAirport("4");
		assertEquals(air,airport);
		assertEquals("4",air.getAirportCode());
		
	}*/
	
	@Test
	public void updateAirport() {
		Airport airport=new Airport("5","Bhegumpet","Hyd");
		adao.findByairportName("Hyd");
		adao.save(airport);
		verify(adao,Mockito.times(1)).save(airport);
	}
	
	@Test
	public void deleteAirport() {
		Airport airport=new Airport("6","Ghandi","Shamshabad");
		adao.deleteById("6");
		verify(adao,times(1)).deleteById("6");
	}
	
	@Mock
	private FlightRepository fdao;
	
	@InjectMocks
	private FlightService flightService;
	
	@Test
	public void testfindAllflights() {
		List<Flight> flightList=new ArrayList<>();
		flightList.add(new Flight(1,"ABC","AirIndia",80));
		flightList.add(new Flight(23,"Aero","Emairates",60));
		Mockito.when(fdao.findAll()).thenReturn(flightList);
		List<Flight> result=fdao.findAll();
		assertEquals(2,result.size());
	}
	
	@Test
	public void testaddFlight() {
		Flight flight=new Flight();
		flight.setFlightNumber(1);
		flight.setFlightModel("Aero");
		flight.setCarrierName("AirIndia");
		flight.setSeatCapacity(40);
		fdao.save(flight);
		
	}
	
	@Test
	public void updateFlight() {
		Flight flight=new Flight(3,"XYZ","Emairates",90);
		fdao.findById(3);
		fdao.save(flight);
		verify(fdao,Mockito.times(1)).save(flight);
	}
	
	@Test
	public void deleteFlight() {
		Flight flight=new Flight(5,"AD","Air",80);
		fdao.deleteById(5);
		verify(fdao,times(1)).deleteById(5);
	}
	
	
	@Mock
	private  ScheduledFlightRepository fsdao;
	
	@InjectMocks
	private ScheduledFlightService scheduledFlightService;
	
	@Mock
	private PassengerRepository pdao;
	
	@InjectMocks
	private PassengerService passengerservice;
	
	
	@Test
	public void testfindAllpassengers() {
		List<Passenger> passengerList=new ArrayList<>();
		passengerList.add(new Passenger(1,"sony",21,55,"Female"));
		passengerList.add(new Passenger(2,"preethi",21,45,"Female"));
		Mockito.when(pdao.findAll()).thenReturn(passengerList);
		List<Passenger> result=pdao.findAll();
		assertEquals(2,result.size());
	}
	
	@Test
	public void testaddPassenger() {
		Passenger passenger=new Passenger();
		passenger.setPassengerage(21);
		passenger.setPassengername("sai");
		passenger.setPassengerUIN(23);
		passenger.setPnrnumber(123);
		passenger.setPassengergender("Male");
		pdao.save(passenger);
		
	}
	
	@Test
	public void updatePassenger() {
		Passenger passenger=new Passenger(3,"Anu",27,234,"Male");
		pdao.findById(3);
		pdao.save(passenger);
		verify(pdao,Mockito.times(1)).save(passenger);
	}
	
	@Test
	public void deletePassenger() {
		Passenger passenger=new Passenger(3,"kavitha",30,67,"Female");
		pdao.deleteById(3);
		verify(pdao,times(1)).deleteById(3);
	}
	
	@Mock
	private UserRepository udao;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	public void testfindAlluser() {
		List<Userdata> userList=new ArrayList<>();
		userList.add(new Userdata(1,"Admin","sony","sony",809646811,"sony@gmail.com",null));
		userList.add(new Userdata(2,"customer","preethi","preethi",995938111,"preethi@gmail.com",null));
		Mockito.when(udao.findAll()).thenReturn(userList);
		List<Userdata> result=udao.findAll();
		assertEquals(2,result.size());
	}
	
	@Test
	public void testaddUser() {
		Userdata user=new Userdata();
		user.setBooking(null);
		user.setUseremail("sony@gmail.com");
		user.setUserid(12);
		user.setUsername("sony");
		user.setUserphone(809646811);
		user.setUsertype("Admin");
		udao.save(user);
		
	}
	
	@Test
	public void updateUser() {
		Userdata user=new Userdata(5,"Admin","anu","anu",809646811,"anu@gmail.com",null);
		udao.findById(3);
		udao.save(user);
		verify(udao,Mockito.times(1)).save(user);
	}
	
	@Test
	public void deleteUser() {
		Userdata user=new Userdata(3,"Admin","bhuvan","bhuvan",994885411,"bhuvan@gmail.com",null);
		udao.deleteById(3);
		verify(udao,times(1)).deleteById(3);
	}
	
	
	@Mock
	private BookingRepository bookingDao;
	
	@InjectMocks
	private BookingService bookingService;
	
	@Test
	public void testfindAllBooking() {
		List<Booking> bookingList=new ArrayList<>();
		bookingList.add(new Booking("12","5/5/2020",800,12,null,null,"sony"));
		bookingList.add(new Booking("16","5/7/2020",900,99,null,null,"preethi"));
		Mockito.when(bookingDao.findAll()).thenReturn(bookingList);
		List<Booking> result=bookingDao.findAll();
		assertEquals(2,result.size());
	}
	
	
	@Test
	public void testaddBooking() {
		Booking booking=new Booking();
		booking.setBookingId("12");
		booking.setBookingDate("23/01/2020");
		booking.setNoOfPassengers(80);
		booking.setPassenger(null);
		booking.setScheduledflight(null);
		booking.setUsername("sony");
		booking.setTicketCost(800);
		bookingDao.save(booking);
		
	}
	
	@Test
	public void updateBooking() {
		Booking booking=new Booking("3","5/5/2020",800,12,null,null,"sony");
		bookingDao.findById("3");
		bookingDao.save(booking);
		verify(bookingDao,Mockito.times(1)).save(booking);
	}
	
	@Test
	public void deleteBooking() {
		Booking booking=new Booking("3","5/5/2020",800,12,null,null,"sony");
		bookingDao.deleteById(3);
		verify(bookingDao,times(1)).deleteById(3);
	}

}
