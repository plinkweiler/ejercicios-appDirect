package com.airline.manager.model.flight;

import com.airline.manager.model.seat.NoSeatAvailableException;
import com.airline.manager.model.seat.Seat;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Flight {

	private final String flightNo;

	private final String origin;

	private final String destination;

	private Map<Grade, Section> sectionMap = new HashMap<>();

	public Flight(String flightNo, String origin, String destination, Map<Grade, Set<Seat>> seats) {
		this.flightNo = flightNo;
		this.origin = origin;
		this.destination = destination;
		seats.entrySet().forEach(entry -> sectionMap.put(entry.getKey(), new Section(entry.getValue())));
	}

	public String getFlightNo() {
		return flightNo;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public long countAvailableSeats(Grade grade) {
		return sectionMap.get(grade).countAvailableSeats();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightNo == null) ? 0 : flightNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (flightNo == null) {
			if (other.flightNo != null)
				return false;
		} else if (!flightNo.equals(other.flightNo))
			return false;
		return true;
	}

}
