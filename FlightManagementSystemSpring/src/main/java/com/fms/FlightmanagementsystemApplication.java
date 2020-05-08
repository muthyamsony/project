package com.fms;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@SpringBootApplication
@EntityScan(basePackages={"com.fms.*"})
public class FlightmanagementsystemApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(FlightmanagementsystemApplication.class, args);
	}
}

