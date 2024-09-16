
public abstract class Vehicle {
	private String color;
	private String id;
	
	
	public Vehicle(String color, String id) {
		
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public abstract void drive();

	@Override
	public String toString() {
		return "Vehicle [color=" + color + ", id=" + id + "]";
	}

}


