/**
 * 
 */
package org.redhat.worksho;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.redhat.workshop.BookingService;
import org.redhat.workshop.BookingServicesDefaultImpl;
import org.redhat.workshop.Customer;
import org.redhat.workshop.Event;
import org.redhat.workshop.Seat;

/**
 * @author rpelisse
 * 
 */
public class BookingServices {

	private Customer customer;
	private BookingService impl;

	@Before
	public void setUpEventDb() {
		final String targetLabel = "Metallica Concert";
		List<Event> events = new ArrayList<Event>();
		events.add(new Event(0, targetLabel, 100, 1000));
		events.add(new Event(1, "Chicago Musical", 140, 880));
		events.add(new Event(2, "ABBA Live performance", 70, 2000));
		events.add(new Event(3, "Beyoncé Show", 100, 1000));
		events.add(new Event(4, "San Francisco Symphonic recital", 100, 1000));

		customer = new Customer(1, "rpelisse", "password");
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		customers.add(new Customer(2, "other", "otherPassword"));

		impl = new BookingServicesDefaultImpl(events, customers);
	}

	@Test
	public void testSimpleUseCase() {
		Seat seat = impl.book(new Event("Metallica Concert"), customer);
		assertTrue("Seat should be booked", seat.isBooked());
	}

	@Test
	public void noSuchEvent() {
		Seat seat = impl.book(new Event("Bob Marley Concert"), customer);// he is dead !
		assertFalse("Seat should be booked", seat.isBooked());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNullCustomer() {
		impl.book(new Event("Metallica Concert"), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullEvent() {
		impl.book(null, customer);
	}

		
	
}
