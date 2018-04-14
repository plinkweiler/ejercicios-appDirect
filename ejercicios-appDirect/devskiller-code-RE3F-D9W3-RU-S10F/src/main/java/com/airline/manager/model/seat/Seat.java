package com.airline.manager.model.seat;

public class Seat {

	private final String number;

	private Status status = Status.AVAILABLE;

	public Seat(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public Status getStatus() {
		return status;
	}

	public boolean isAvailable() {
		return status == Status.AVAILABLE;
	}

	public void reserve() {
		status = Status.RESERVED;
	}

	public enum Status {
		AVAILABLE, RESERVED
	}
}
