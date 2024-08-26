
public class TestDriver {

	public static void main(String[] args) {
		Car myCar = new Car("pink", 5600, true, 12.5);
		System.out.println(myCar);
		
		// composition - pulling another object into your object
		System.out.println(myCar.getWheels()[1]);
		
		myCar.setRadio(new Radio(true, true, 5));
		
		//myCar.getRadio().volume = 13;

	}

}
