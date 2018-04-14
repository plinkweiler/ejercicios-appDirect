package com.airline.manager.model.flight;

import com.airline.manager.model.seat.Seat;
import com.airline.manager.model.seat.SeatsGenerator;

import java.util.HashMap;
import java.util.Set;

public class FlightBuilder {

	private String flightNo;
	private String origin;
	private String destination;
	private HashMap<Grade, Set<Seat>> seats = new HashMap<>();

	public static FlightBuilder aFlight() {
		return new FlightBuilder();
	}

	public FlightBuilder withFlightNo(String flightNo) {
		this.flightNo = flightNo;
		return this;
	}

	public FlightBuilder withOrigin(String origin) {
		this.origin = origin;
		return this;
	}

	public FlightBuilder withDestination(String destination) {
		this.destination = destination;
		return this;
	}

	public FlightBuilder addSeats(Grade grade, int rows, int seatsInRow, int firstRowNumber) {
		seats.put(grade, new SeatsGenerator().createSeats(rows, seatsInRow, firstRowNumber));
		return this;
	}

	public Flight createFlight() {
		return new Flight(flightNo, origin, destination, seats);
	}
}