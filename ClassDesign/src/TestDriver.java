
public class TestDriver {

	public static void main(String[] args) {
		Car myCar = new Car("pink", 5600, true, 12.5);
		System.out.println(myCar);
		
		System.out.println(myCar.getWheels()[1]);

	}

}
