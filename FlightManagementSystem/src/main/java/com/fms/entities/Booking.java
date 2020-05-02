package com.fms.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fms.entities.Userdata;



@Entity
@Table(name="Booking")
public class Booking implements Serializable{
	@Id
	@Column(name="booking_id")
	private int bookingId;
	@Column(name="booking_date")
	private Date bookingDate;
	@Column(name="ticket_cost")
	private double ticketCost;
	@Column(name="no_of_passengers")
	private int noOfPassengers;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Userdata userid;
	
	@OneToMany
	@JoinColumn(name="booking_id")
	private List<Passenger> passenger= new ArrayList<Passenger>();

	@OneToOne
    @JoinColumn(name="scheduledflight_id")
    private Scheduledflight scheduledflightid;

	public Booking() {
		
	}

	public Booking(int bookingId, Date bookingDate, double ticketCost, int noOfPassengers, Userdata userid,
			List<Passenger> passenger, Scheduledflight scheduledflightid) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.noOfPassengers = noOfPassengers;
		this.userid = userid;
		this.passenger = passenger;
		this.scheduledflightid = scheduledflightid;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public Userdata getUserid() {
		return userid;
	}

	public void setUserid(Userdata userid) {
		this.userid = userid;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public Scheduledflight getScheduledflightid() {
		return scheduledflightid;
	}

	public void setScheduledflightid(Scheduledflight scheduledflightid) {
		this.scheduledflightid = scheduledflightid;
	}

	
	
	
}
