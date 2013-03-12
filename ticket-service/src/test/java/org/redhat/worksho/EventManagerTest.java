package org.redhat.worksho;

import org.junit.Ignore;
import org.junit.Test;
import org.redhat.workshop.Event;

public class EventManagerTest {
	
	private EventManager manager = new EventManagerDefaultImpl();
	
	@Test
	@Ignore
	public void addEvent() {
		manager.addEvent(new Event(""));
	}

	@Test
	@Ignore
	public void removeEvent() {
		manager.removeEvent(new Event(""));
	}
	
}
