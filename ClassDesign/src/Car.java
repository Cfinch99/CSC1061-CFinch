
public class Car {
	//data members
	private String color;
	private int mileage;
	private boolean isClean;
	private double amountOfGas;
	private Wheel[] wheels = new Wheel[4];
	private Radio radio;
	
	//constructors
	public Car() {
		color = "grey";
		mileage = 0;
		amountOfGas = 1.0;
		isClean = true;
		setWheelsOnCar();
	}
	public Car(String color, boolean isClean) {
		this.color = color;
		this.isClean = isClean;
		setWheelsOnCar();
	}
	public Car(String color, int mileage, boolean isClean, double amountOfGas) {
		super();
		this.color = color;
		this.mileage = mileage;
		this.isClean = isClean;
		this.amountOfGas = amountOfGas;
		setWheelsOnCar();
	}
	
	// getters and setters - encapsulate data members
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public boolean isClean() {
		return isClean;
	}
	public void setClean(boolean isClean) {
		this.isClean = isClean;
	}
	public double getAmountOfGas() {
		return amountOfGas;
	}
	public void setAmountOfGas(double amountOfGas) {
		this.amountOfGas = amountOfGas;
	}
	
	public Wheel[] getWheels() {
		return wheels;
	}
	public void setWheels(Wheel[] wheels) {
		this.wheels = wheels;
	}
	public Radio getRadio() {
		return radio;
	}
	public void setRadio(Radio radio) {
		this.radio = radio;
	}
	
	// static belongs to class, not instance method
	public void drive(int numMiles) {
		for(int i = 0; i < numMiles; i++) {
			System.out.println("+");
			amountOfGas -= 0.1;
		}
		System.out.println();
		mileage += numMiles;
	}
	
	public void cleanCar() {
		isClean = true;
	}
	
	
	private void setWheelsOnCar() {
		for (int i = 0; i < wheels.length; i++) {
			wheels[i] = new Wheel(15, "Alloy");
		}
	}
	
	
	@Override
	public String toString() {
		String str = " Color: " + color + "\n Mileage: " + mileage + "\n Clean: "
	     + isClean + " \n Gallons of gas: " + amountOfGas;
		return str;
	}
	
}
