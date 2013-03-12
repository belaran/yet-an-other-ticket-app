package org.redhat.workshop;

import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final String targetLabel = "Metallica Concert";
		List<Event> events = new ArrayList<Event>();
		events.add( new Event(0, targetLabel, 100, 1000) );
		events.add( new Event(1,"Chicago Musical", 140, 880) );
		events.add( new Event(2,"ABBA Live performance", 70, 2000) );
		events.add( new Event(3,"Beyoncé Show", 100, 1000) );
		events.add( new Event(4,"San Francisco Symphonic recital", 100, 1000) );
		
		Customer customer = new Customer(1, "rpelisse","password");
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		customers.add(new Customer(2, "other","otherPassword"));
		
		BookingService impl = new BookingServicesDefaultImpl(events, customers);
		Seat seat = impl.book(new Event("Metallica Concert"), customer);
		if ( ! seat.isBooked() )
			throw new IllegalStateException("Fail booking");
		System.out.println("Seat booked.");
		

	}

}
