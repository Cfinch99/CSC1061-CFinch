//for each loop in next assignment
// for (Animal animals : stalls)
// stalls is an array of animals
// if animal instance of cat // looking for cats in the stalls

// relational database
// learn sql put on resume
// Junit, github, logging and testing, etc on resume
// 
public class Rectangle extends GeometricObject{
	
	private double width;
	private double height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public Rectangle(String color, boolean isFilled, double width, double height) {
		super(color, isFilled);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public boolean equals(Object obj) {
		Rectangle rect = null;
		if (obj instanceof Rectangle 
				&& width == ((Rectangle)obj).width 
						&& height == ((Rectangle)obj).height) {
			return true;
		}
		return false;
	}
	
	
	public double getArea() {
		return width * height;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", getColor()=" + getColor() + ", isFilled()="
				+ isFilled() + ", getDateCreated()=" + getDateCreated() + "]";
	}
	
	
	
	
	

}
