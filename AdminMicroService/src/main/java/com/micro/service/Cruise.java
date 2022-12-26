package com.micro.service;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class Cruise {

	@Id
	private int cruiseId;
	//@NotBlank(message = "Cruise Destination is mandatory")
	private String cruiseDestination;
	private String cruiseLine;
	//@Past(message="Date has to be in the past")
	private Date departureDate;
	private String visitingPlaces;
	//@NotBlank(message = "Duration is mandatory")
	private int duration;
	//@NotBlank(message = "Price is mandatory")
	private float price;
	
	public Cruise() {
		
	}

	public Cruise(int cruiseId, String cruiseDestination, String cruiseLine, Date departureDate, String visitingPlaces,
			int duration, float price) {
		super();
		this.cruiseId = cruiseId;
		this.cruiseDestination = cruiseDestination;
		this.cruiseLine = cruiseLine;
		this.departureDate = departureDate;
		this.visitingPlaces = visitingPlaces;
		this.duration = duration;
		this.price = price;
	}

	public int getCruiseId() {
		return cruiseId;
	}

	public void setCruiseId(int cruiseId) {
		this.cruiseId = cruiseId;
	}

	public String getCruiseDestination() {
		return cruiseDestination;
	}

	public void setCruiseDestination(String cruiseDestination) {
		this.cruiseDestination = cruiseDestination;
	}

	public String getCruiseLine() {
		return cruiseLine;
	}

	public void setCruiseLine(String cruiseLine) {
		this.cruiseLine = cruiseLine;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getVisitingPlaces() {
		return visitingPlaces;
	}

	public void setVisitingPlaces(String visitingPlaces) {
		this.visitingPlaces = visitingPlaces;
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
