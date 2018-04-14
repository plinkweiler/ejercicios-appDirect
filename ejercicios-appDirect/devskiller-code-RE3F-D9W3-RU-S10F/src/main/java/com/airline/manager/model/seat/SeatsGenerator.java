package com.airline.manager.model.seat;

import java.util.HashSet;
import java.util.Set;

public class SeatsGenerator {

	public Set<Seat> createSeats(int rows, int seatsInRow, int firstRowNumber) {
		
		Set<Seat> seats = new HashSet<>();
		for (int i = firstRowNumber; i < (firstRowNumber + rows); i++) {
			
			for (int j = 0; j < seatsInRow; j++) {
				
				char letter = (char) ('A' + j);
				String number = String.valueOf(i) + letter;
				Seat seat = new Seat(number);
				seats.add(seat);
			}
			
		}
		
		return seats;
	}
}
