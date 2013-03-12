/**
 * Copyright : @Red Hat
 */
package org.redhat.workshop;

/**
 * @author Romain Pelise <belaran@gmail.com>
 * @author Romain Pelise <belaran@redhat.com>
 *
 */
public interface BookingService {
	
	public Seat book(Event event, Customer customer);
}
