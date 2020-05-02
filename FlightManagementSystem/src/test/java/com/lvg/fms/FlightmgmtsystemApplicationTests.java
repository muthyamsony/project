package com.lvg.fms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.fms.entities.Flight;
import com.fms.repository.FlightRepository;
import com.fms.service.FlightService;

@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
class FlightmgmtsystemApplicationTests {

	/*@Test
	void contextLoads() {
	}*/
	
	
	@Mock
	private FlightRepository flightRepository;
	
	@InjectMocks
	private FlightService flightService;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testviewFlight() {
		List<Flight> flightList=new ArrayList<Flight>();
		flightList.add(new Flight(1,"ABC","Air India",50));
		flightList.add(new Flight(2,"ABC100","Emairates",100));
		flightList.add(new Flight(3,"ABC101","Air India",20));
		when(flightRepository.findAll()).thenReturn(flightList);
		List<Flight> result=flightService.viewFlight();
		assertEquals(2,result.size());
		
	}
	
	@Test
	public void testaddFlight() {
		Flight flight=new Flight(4,"Aero","Emairates",100);
		when(flightRepository.save(flight)).thenReturn(flight);
		Flight result=flightService.addFlight(flight);
		assertEquals(4,result.getFlightNumber());
		
	}

}
