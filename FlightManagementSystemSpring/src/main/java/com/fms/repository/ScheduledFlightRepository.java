package com.fms.repository;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fms.entities.Airport;
import com.fms.entities.Scheduledflight;


@Repository
public interface ScheduledFlightRepository  extends JpaRepository<Scheduledflight,Serializable>
{
	@Query("select sf,f from Scheduledflight sf, Flight f where  sf.sourceairport.airportName=?1 and sf.destinationairport.airportName=?2 ")
	List<Scheduledflight> findAllByAirport(String source, String destination);
	
}
