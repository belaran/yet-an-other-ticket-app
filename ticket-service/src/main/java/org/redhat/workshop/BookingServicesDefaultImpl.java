package org.redhat.workshop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingServicesDefaultImpl implements BookingService {
	
	private Map<String,Event> events;
	private Map<String,Customer> customers;

	public BookingServicesDefaultImpl(List<Event> events,
			List<Customer> customers) {
		this.events = indexEventsByName(events);
		this.customers = indexCustomersByUsername(customers);
	}

	private static Map<String,Customer> indexCustomersByUsername(List<Customer> customers) {
		Map<String,Customer> map = new HashMap<String, Customer>(customers.size());
		for ( Customer customer : customers ) 
			map.put(customer.getUsername(), customer);
		return map;
	}

	private static Map<String, Event> indexEventsByName(List<Event> events) {
		Map<String, Event> map = new HashMap<String, Event>(events.size());
		for ( Event event : events )
			map.put(event.getLabel(), event);
		return map;		
	}

	@Override
	public Seat book(Event event, Customer customer) {
		
		if ( customer == null )
			throw new IllegalArgumentException("Customer can not be null:" + customer);
		Customer registeredCustomer = customers.get(customer.getUsername());			
			
		if ( event == null )
			throw new IllegalArgumentException("Event can't be null");
		
		Event availableEvent = events.get(event.getLabel());
		if ( availableEvent != null && availableEvent.hasSeatAvailable() ) {			
			Seat bookedSeat = new Seat(availableEvent, registeredCustomer);
			availableEvent.getAllocatedSeat().add(bookedSeat);
			registeredCustomer.getSeats().add(bookedSeat);
			return bookedSeat;
		}
		return new Seat();
	}
	
}
