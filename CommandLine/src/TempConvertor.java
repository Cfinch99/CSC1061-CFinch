
public class TempConvertor {

	public static void main(String[] args) {
		//run as -- run config -- arguments -- "-f" "34"
		// change java file to class file
		//java classname  
		double answer = 0.0;
		
		if(args.length != 2) {
			System.out.println("Usage:");
			System.out.println("\t -f temp  Convert celsius to fahrenheit");
			System.out.println("\t -c temp  Convert fahrenheit to celsius");
		}
		
		if(args[0].equals("-f")) {
			answer = ConvertCelToFah(Double.parseDouble(args[1]));
			System.out.println("The Fahrenheit value is: " + answer);
		}
		if(args[0].equals("-c")) {
			answer = ConvertFahToCel(Double.parseDouble(args[1]));
			System.out.println("The Celsius value is: " + answer);
		}

	}

	public static double ConvertFahToCel(double input) {
		return ((input - 32) *(5.0/9.0));
	}
	
	public static double ConvertCelToFah(double input) {
		return ((input *(9.0/5.0)) + 32);
	}
}
