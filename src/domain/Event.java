package domain;

// Value Object
public abstract class Event { // utile pour faire du polymorphisme et factoriser la capacité
	private final int DESIRED_CAPACITY;
	
	public Event(int desiredCapacity) {
		this.DESIRED_CAPACITY = desiredCapacity;
	}
	
	public int getDesiredCapacity() {
		return this.DESIRED_CAPACITY;
	}
}
