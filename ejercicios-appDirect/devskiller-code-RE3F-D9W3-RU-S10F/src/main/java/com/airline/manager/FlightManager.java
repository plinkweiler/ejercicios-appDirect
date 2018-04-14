package com.airline.manager;

import com.airline.manager.model.flight.Flight;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightManager {

	private Set<Flight> flights = new HashSet<>();

	public boolean addNewFlight(Flight flight) {
		
		return flights.add(flight);
	}

	public Set<Flight> findFlightsBetween(String origin, String destination, boolean directionSensitive) {
		
		Set<Flight> flightsFiltered = new HashSet<>();
		
		if(directionSensitive) {
			
			flightsFiltered =	flights.stream().
					filter(f ->f.getOrigin().equals(origin) && f.getDestination().equals(destination)).collect(Collectors.toSet());
			
		}else {		
		flightsFiltered =	flights.stream().
			filter(f ->(f.getOrigin().equals(origin) && f.getDestination().equals(destination))
					|| (f.getOrigin().equals(destination) && f.getDestination().equals(origin))
					).collect(Collectors.toSet());
		
		}
		
		return flightsFiltered; // TODO: Implement
	}
}
