package com.airline.manager.model.seat

import spock.lang.Specification

class SeatsGeneratorSpec extends Specification {

	def "should generate seats"() {
		given:
			SeatsGenerator generator = new SeatsGenerator()
		when:
			Set<Seat> seats = generator.createSeats(2, 2, 4)
		then:
			seats.size() == 4
			seats.number as Set == ['4A', '4B', '5A', '5B'] as Set
	}

}
