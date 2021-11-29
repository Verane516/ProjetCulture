package domain;

// https://youtu.be/il7eVsDPFoA?t=415
// https://mkyong.com/java/java-date-and-calendar-examples/ - Example 2.2

// Value Object
public abstract class Event { // utile pour faire du polymorphisme et factoriser la capacité
	private final int DESIRED_CAPACITY;
	
	
	public Event(int desiredCapacity) {
		this.DESIRED_CAPACITY = desiredCapacity;
		
	}
	
	public int getDesiredCapacity() {
		return this.DESIRED_CAPACITY;
	}
	
	public abstract boolean checkDate(Slot slot);
}
