package com.airline.manager

import com.airline.manager.model.flight.Flight
import com.airline.manager.model.flight.FlightBuilder
import spock.lang.Specification

import static com.airline.manager.model.flight.FlightBuilder.aFlight

class FlightManagerSpec extends Specification {

	def "flights are unique"() {
		given:
			FlightManager manager = new FlightManager()
			Flight flight1 = FlightBuilder.aFlight().withFlightNo("LO522").createFlight();
			manager.addNewFlight(flight1)

			Flight flight2 = FlightBuilder.aFlight().withFlightNo("LO522").createFlight();
		when:
			boolean added = manager.addNewFlight(flight2)
		then:
			!added
	}

	def "should find flights between airports"() {
		given:
			FlightManager manager = new FlightManager()
			manager.addNewFlight(aFlight().withFlightNo("LO1533").withOrigin("WAW").withDestination("MUC").createFlight())
			manager.addNewFlight(aFlight().withFlightNo("LH1232").withOrigin("JFK").withDestination("PAR").createFlight())
			manager.addNewFlight(aFlight().withFlightNo("YH1732").withOrigin("GDA").withDestination("MOS").createFlight())
		when:
			Set<Flight> flights = manager.findFlightsBetween("WAW", "MUC",  false)
		then:
			flights.size() == 1
	}
}
