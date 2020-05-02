package com.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Passenger")
public class Passenger implements Serializable{
	@Id
	private int pnrnumber;
	private String passengername;
	private int passengerage;
	private int passengerUIN;
	private double luggage;
	
	public Passenger() {
		
	}

	public Passenger(int pnrnumber, String passengername, int passengerage, int passengerUIN, double luggage) {
		
		this.pnrnumber = pnrnumber;
		this.passengername = passengername;
		this.passengerage = passengerage;
		this.passengerUIN = passengerUIN;
		this.luggage = luggage;
	}

	public int getPnrnumber() {
		return pnrnumber;
	}

	public void setPnrnumber(int pnrnumber) {
		this.pnrnumber = pnrnumber;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public int getPassengerage() {
		return passengerage;
	}

	public void setPassengerage(int passengerage) {
		this.passengerage = passengerage;
	}

	public int getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(int passengerUIN) {
		this.passengerUIN = passengerUIN;
	}

	public double getLuggage() {
		return luggage;
	}

	public void setLuggage(double luggage) {
		this.luggage = luggage;
	}
	
	
	
}
