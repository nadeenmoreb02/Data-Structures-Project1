package application;

public class Node {
	Object obj;
	Node nextFlight;
	Node nextPassenger;

	public Node(Object obj) {
		super();
		this.obj = obj;
		this.nextFlight = null;
		this.nextPassenger = null;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Flight getFlight() {
		return (Flight) obj;
	}

	public void setFlight(Flight obj) {
		this.obj = obj;
	}

	public Passenger getPassenger() {
		return (Passenger) obj;
	}

	public void setPassenger(Passenger obj) {
		this.obj = obj;
	}

	public Node getNextFlight() {
		return nextFlight;
	}

	public void setNextFlight(Node nextFlight) {
		this.nextFlight = nextFlight;
	}

	public Node getNextPassenger() {
		return nextPassenger;
	}

	public void setNextPassenger(Node nextPassenger) {
		this.nextPassenger = nextPassenger;
	}

	@Override
	public String toString() {
		return "" + obj + "\n";
	}

}
