package org.redhat.workshop;

public class Seat {

	private Event event;
	private Customer customer;
	
	@Override
	public String toString() {
		if ( ! this.isBooked() )
			return "No Seat booked.";
		return "Seat booked for [" + event + "], by customer '" + customer + "'.";
	}

	public Seat(Event event, Customer customer) {
		if ( event == null )
			throw new IllegalArgumentException("Event can't be null:");
		if ( customer == null )
			throw new IllegalArgumentException("Event can't be null:");
		
		this.event = event;
		this.customer = customer;
	}
	
	public boolean isBooked() {
		return ( event != null && customer != null );
	}
	
	public Seat() {	}

	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
