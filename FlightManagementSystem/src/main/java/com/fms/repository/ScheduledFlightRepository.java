package com.fms.repository;
import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fms.entities.Airport;
import com.fms.entities.Scheduledflight;


@Repository
public interface ScheduledFlightRepository  extends JpaRepository<Scheduledflight,Serializable>
{
	@Query("select sf from Scheduledflight sf, Flight f where sf.flight=f.flightNumber and sf.sourceairport=?1 and sf.destinationairport=?2 and sf.arrivaltime=?3")
	Scheduledflight findByAirport(Airport source, Airport destination, Date date);
	
}
