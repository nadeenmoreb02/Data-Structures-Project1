package application;

import java.util.*;

public class Passenger {
	int flightNumber;
	int ticketNumber;
	String fullName;
	String passport;
	String nationality;
	Date birthDate;

	public Passenger(int flightNumber, int ticketNumber, String fullName, String passport, String nationality,
			Date birthDate) {
		this.flightNumber = flightNumber;
		this.ticketNumber = ticketNumber;
		this.fullName = fullName;
		this.passport = passport;
		this.nationality = nationality;
		this.birthDate = birthDate;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int tickerNumber) {
		this.ticketNumber = tickerNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Passenger," + flightNumber + "," + ticketNumber + "," + fullName + "," + passport + "," + nationality
				+ "," + birthDate;
	}

}
