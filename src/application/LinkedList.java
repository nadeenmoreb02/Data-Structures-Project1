package application;

public class LinkedList {
	Node header;
	Node tailor;

	public void insertAtLastPass(Passenger passenger) {
		Node newnode = new Node(passenger);
		if (tailor == null) {
			tailor = newnode;
			header = newnode;
		} else {
			tailor.nextPassenger = newnode;
			tailor = newnode;
		}
	}

	public void insertAtLastFlight(Flight flight) {
		Node newnode = new Node(flight);
		if (tailor == null) {
			tailor = newnode;
			header = newnode;
		} else {
			tailor.nextFlight = newnode;
			tailor = newnode;
		}
	}

	public void printPassList() {
		Node current = header;
		while (current != null) {
			System.out.println(current.getObj().toString());
			current = current.nextPassenger;
		}
	}

	public void printFlightList() {
		Node current = header;
		while (current != null) {
			System.out.println(current.getObj().toString());
			current = current.nextFlight;
		}
	}

	public String printSpecificFlightPass(int number) {
		Node current = header;
		String str = "";
		while (current != null) {
			if (current.getPassenger().getFlightNumber() == number) { 
				str += current.getObj().toString() + "\n";
			}

			current = current.nextPassenger;
		}
		return str;
	}

	public String returnFlightList() {
		Node current = header;
		String str = "";
		while (current != null) {
			str += current.getObj().toString() + "\n";
			current = current.nextFlight;
		}
		return str;
	}

	public void sortFList() {

		Node current = header;
		Node index = null;

		Flight temp;

		if (header == null) {
			return;
		} else {
			while (current != null) {
				index = current.nextFlight;

				while (index != null) {
					if (current.getFlight().getFlightNumber() > index.getFlight().getFlightNumber()) {
						temp = current.getFlight();
						current.setFlight(index.getFlight());
						index.setFlight(temp);
					}

					index = index.nextFlight;
				}
				current = current.nextFlight;
			}
		}
	}

	public void sortPList() {

		Node current = header;
		Node index = null;

		Passenger temp;

		if (header == null) {
			return;
		} else {
			while (current != null) {
				index = current.nextPassenger;
				while (index != null) {
					if (current.getPassenger().getFullName()
							.compareToIgnoreCase(index.getPassenger().getFullName()) > 0) {
						temp = current.getPassenger();
						current.setPassenger(index.getPassenger());
						index.setPassenger(temp);
					}

					index = index.nextPassenger;
				}
				current = current.nextPassenger;
			}
		}
	}

	public Flight searchFlight(int key) {
		Node current = header;
		if (header == null) {
			return null;
		}
		while (current != null && current.getFlight().getFlightNumber() != key) {
			current = current.nextFlight;
		}
		if (current.getFlight().getFlightNumber() == key) {
			return current.getFlight();
		}
		return null;
	}

	public void editFlight(int key, Flight newFlight) {
		Node current = header;
		Node newNode = new Node(newFlight);
		if (header == null) {
			header = newNode;
		}
		while (current != null && current.getFlight().getFlightNumber() != key) {
			current = current.getNextFlight();
		}
		if (current.getFlight().getFlightNumber() == key) {
			current.setFlight(newFlight);
		} else {
			current.setNextFlight(newNode);
		}
	}

	public void editFlightNumberInPassengers(int key, int newKey) {
		Node current = header;
		if (header == null) {
			return;
		}
		while (current != null) {
			if (current.getPassenger().getFlightNumber() == key) {
				current.getPassenger().setFlightNumber(newKey);
			}
			current = current.getNextPassenger();
		}
	}

	public Passenger searchPassenger(String key) {
		Node current = header;
		if (header == null) {
			return null;
		}
		while (current != null && !current.getPassenger().getFullName().equalsIgnoreCase(key)) {
			current = current.nextPassenger;
		}
		if (current.getPassenger().getFullName().equals(key)) {
			return current.getPassenger();
		}
		return null;
	}

	public int reserveTicket(int number) {
		Node current = header;
		int max = -9;
		while (current != null) {
			if (current.getPassenger().getFlightNumber() == number) {
				if (current.getPassenger().getTicketNumber() > max) {
					max = current.getPassenger().getTicketNumber();
				}
			}
			current = current.nextPassenger;
		}
		return max + 1;
	}

	public boolean checkCapacity(int key, LinkedList pass, LinkedList flight) {
		Node currentFlight = flight.header;
		Node currentPass = pass.header;
		int count = 0;
		int capacity = 10000;
		while (currentFlight != null) {
			if (currentFlight.getFlight().getFlightNumber() == key) {
				capacity = currentFlight.getFlight().getCapacity();
				break;
			}
			currentFlight = currentFlight.nextFlight;
		}
		while (currentPass != null) {
			if (currentPass.getPassenger().getFlightNumber() == key) {
				count += 1;
			}
			currentPass = currentPass.nextPassenger;
		}
		if (capacity > count) {
			return true;
		}
		return false;
	}

	public void cancelReservation(int number, String name) {
		Node current = header;
		Node prev = null;
		if (current.getPassenger().getFlightNumber() == number
				&& current.getPassenger().getFullName().equalsIgnoreCase(name)) {
			header = current.nextPassenger;
			current.nextPassenger=null;
			return;
		}
		while (current != null) {
			if (current.getPassenger().getFlightNumber() == number
					&& current.getPassenger().getFullName().equalsIgnoreCase(name)) {
				prev.nextPassenger = current.nextPassenger;
				current.nextPassenger = null;
			}
			prev = current;
			current = current.nextPassenger;
		}
	}

	public boolean checkReservation(int number, String name) {
		Node current = header;
		while (current != null) {
			if (current.getPassenger().getFlightNumber() == number
					&& current.getPassenger().getFullName().equalsIgnoreCase(name)) {
				return true;
			}
			current = current.nextPassenger;
		}
		return false;
	}

}
