package application;

import java.util.*;

public class Flight implements Comparable<Flight> {
	int flightNumber;
	String name;
	String source;
	String destination;
	int capacity;

	public Flight(int flightNumber, String name, String source, String destination, int capacity) {
		this.flightNumber = flightNumber;
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.capacity = capacity;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Flight," + flightNumber + "," + name + "," + source + "," + destination + "," + capacity;
	}

	@Override
	public int compareTo(Flight o) {
		if (flightNumber > o.getFlightNumber()) {
			return 1;
		} else if (flightNumber == o.getFlightNumber()) {
			return 0;
		} else {
			return -1;
		}
	}

}
