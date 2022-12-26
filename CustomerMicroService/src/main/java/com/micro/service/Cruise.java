package com.micro.service;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Cruise {

	@Id
	private int cruiseId;
	private String cruiseName;
	private Date departureDate;
	private int duration;
	private float price;
	
	public Cruise() {
		
	}

	public Cruise(int cruiseId, String cruiseName, Date departureDate, int duration, float price) {
		super();
		this.cruiseId = cruiseId;
		this.cruiseName = cruiseName;
		this.departureDate = departureDate;
		this.duration = duration;
		this.price = price;
	}

	public int getCruiseId() {
		return cruiseId;
	}

	public void setCruiseId(int cruiseId) {
		this.cruiseId = cruiseId;
	}

	public String getCruiseName() {
		return cruiseName;
	}

	public void setCruiseName(String cruiseName) {
		this.cruiseName = cruiseName;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
		
}
