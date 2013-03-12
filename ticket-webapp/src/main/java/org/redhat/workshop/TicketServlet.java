package org.redhat.workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TicketServlet extends HttpServlet {

	private BookingService impl;

	public TicketServlet() {
		final String targetLabel = "Metallica Concert";
		List<Event> events = new ArrayList<Event>();
		events.add(new Event(0, targetLabel, 100, 1000));
		events.add(new Event(1, "Chicago Musical", 140, 880));
		events.add(new Event(2, "ABBA Live performance", 70, 2000));
		events.add(new Event(3, "Beyoncé Show", 100, 1000));
		events.add(new Event(4, "San Francisco Symphonic recital", 100, 1000));

		Customer customer = new Customer(1, "rpelisse", "password");
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(customer);
		customers.add(new Customer(2, "other", "otherPassword"));
		impl = new BookingServicesDefaultImpl(events, customers);
	}

	private static void print(HttpServletResponse response, String message) {
		try {
			response.getWriter().print(message);
		} catch ( IOException e) {
			throw new IllegalStateException(e);
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String eventLabel = request.getParameter("eventLabel");
		if ( eventLabel == null || "".equals(eventLabel) ) {
			print(response, "No event label provided");
			return ;
		}
			
		String username = request.getParameter("username");
		if ( username == null || "".equals(username) ) {
			print(response, "No username provided");
			return ;			
		}		
		print(response, impl.book(new Event(eventLabel), new Customer(username, "")).toString());
	}
}
