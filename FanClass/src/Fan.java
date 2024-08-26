
public class Fan {
	// data types, separated between constants and variables
	private final int SLOW = 1;
	private final int MEDIUM = 2;
	private final int FAST = 3;
	
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5.0;
	private String color = "Blue";
	private int id;
	
	
	// constructor(s)
	
	public Fan() {
		speed = SLOW;
		on = false;
		radius = 5.0;
		color = "Blue";
		id = idMaker(0);
		
	}
	
	public Fan(int speed, boolean on, double radius, String color) {
		this.speed = speed;
		this.on = on;
		this.radius = radius;
		this.color = color;
		id = idMaker(0);
	}
	
	// getters and setters
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if (speed > FAST) {
			this.speed = FAST;
		}
		else {
			this.speed = speed;
		}
	}
	public boolean isOn() {
		return on;
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	//methods
	
	
	private int idMaker(int count) {
		count++;
		return count;
	}

	@Override
	public String toString() {
		if (on) {
			return "Fan ID: " + id + "\n Fan Speed: " + speed 
					+ "\n Color: " + color + "\n Radius: " + radius;
		}
		else {
			return "Fan ID: " + id + "\n Color: " + color + 
					"\n Radius: " + radius + "\n Fan is off";
		}
	}
	
	
	

}
