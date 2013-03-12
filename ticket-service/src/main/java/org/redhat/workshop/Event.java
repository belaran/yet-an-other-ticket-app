package org.redhat.workshop;

import java.util.HashSet;
import java.util.Set;

public class Event {

	private int id;
	private String label;
	private int price;
	private int nbSeat;
	private Set<Seat> allocatedSeat = new HashSet<Seat>();
	
	public Event(int id, String eventName, int price, int nbSeat) {
		this.id = id;
		this.label = eventName;
		this.nbSeat = nbSeat;
		this.price = price;
	}

	public boolean hasSeatAvailable() {
		return (nbSeat - allocatedSeat.size()) > 0;
	}

	public Event(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + nbSeat;
		result = prime * result + ((allocatedSeat == null) ? 0 : allocatedSeat.hashCode());
		result = prime * result + price;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", label=" + label + ", price=" + price
				+ ", nbSeat=" + nbSeat + ", nbSeatSold=" + allocatedSeat.size() + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNbSeat() {
		return nbSeat;
	}
	
	public void setNbSeat(int nbSeat) {
		this.nbSeat = nbSeat;
	}

	public Set<Seat> getAllocatedSeat() {
		return allocatedSeat;
	}

	public void setAllocatedSeat(Set<Seat> allocatedSeat) {
		this.allocatedSeat = allocatedSeat;
	}

}
