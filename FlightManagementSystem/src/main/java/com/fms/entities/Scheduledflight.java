package com.fms.entities;


import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Scheduledflight")
public class Scheduledflight  {
	@Id
	@Column(name="scheduledflight_id")
	private int scheduledflightid;
	@Column(name="available_seats")
	private int availableSeats;
	@Column(name="ticket_cost")
	private long ticketcost;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name="flight_number")
	@NotFound(action = NotFoundAction.IGNORE)
	private Flight flight;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name="sourceairport", referencedColumnName="airport_name")
	 @NotFound(action = NotFoundAction.IGNORE)
	private Airport sourceairport;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name="destinationairport", referencedColumnName="airport_name")
	 @NotFound(action = NotFoundAction.IGNORE)
	private Airport destinationairport;
	

	private Date arrivaltime;
	private Date departuretime;

	public Scheduledflight() {
		
	}

	public Scheduledflight(int scheduledflightid, int availableSeats, long ticketcost, Flight flight,
			Airport sourceairport, Airport destinationairport, Date arrivaltime, Date departuretime) {
		super();
		this.scheduledflightid = scheduledflightid;
		this.availableSeats = availableSeats;
		this.ticketcost = ticketcost;
		this.flight = flight;
		this.sourceairport = sourceairport;
		this.destinationairport = destinationairport;
		this.arrivaltime = arrivaltime;
		this.departuretime = departuretime;
	}

	public int getScheduledflightid() {
		return scheduledflightid;
	}

	public void setScheduledflightid(int scheduledflightid) {
		this.scheduledflightid = scheduledflightid;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public long getTicketcost() {
		return ticketcost;
	}

	public void setTicketcost(long ticketcost) {
		this.ticketcost = ticketcost;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Airport getSourceairport() {
		return sourceairport;
	}

	public void setSourceairport(Airport sourceairport) {
		this.sourceairport = sourceairport;
	}

	public Airport getDestinationairport() {
		return destinationairport;
	}

	public void setDestinationairport(Airport destinationairport) {
		this.destinationairport = destinationairport;
	}

	public Date getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(Date arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public Date getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(Date departuretime) {
		this.departuretime = departuretime;
	}

	
}
