
public class Circle extends GeometricObject{
	
	private double radius = 1.0;

	public Circle() {
		
	}
	
	public Circle(double radius) {
		this.radius = radius;
		
	}
	
	public Circle(String color, boolean isFilled, double radius) {
		super(color, isFilled);
		//setColor(color);
		//setFilled(isFilled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle 
				&& radius == ((Circle)obj).radius) {
			return true;
		}
		return false;
	}
	
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public double getDiameter() {
		return 2 * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", getColor()=" + getColor() + ", isFilled()=" + isFilled()
				+ ", getDateCreated()=" + getDateCreated() + "]";
	}
	
	
}
