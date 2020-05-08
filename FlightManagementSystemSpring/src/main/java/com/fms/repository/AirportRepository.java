package com.fms.repository;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fms.entities.Airport;


@Repository
public interface AirportRepository extends JpaRepository<Airport,String>
{
	@Query("select a from Airport a where a.airportName=?1")
	Airport findByairportName(String airportName);
}
