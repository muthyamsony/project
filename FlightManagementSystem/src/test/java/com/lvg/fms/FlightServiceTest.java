package com.lvg.fms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fms.entities.Flight;
import com.fms.repository.FlightRepository;
import com.fms.service.FlightService;
@RunWith(SpringJUnit4ClassRunner.class)
public class FlightServiceTest {
	
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
	

	
	
		
			
		
	

}
