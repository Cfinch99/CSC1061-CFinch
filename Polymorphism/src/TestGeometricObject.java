import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestGeometricObject {

	public static void main(String[] args) throws FileNotFoundException{
		Circle cir1 = new Circle(2.0);
		cir1.setColor("Red");
		cir1.setFilled(true);
		
		File inputFile = new File("C:\\Users\\Carte\\CSC1061-CFinch\\Polymorphism\\src\\input.txt");
		Scanner input = new Scanner(inputFile);
		//String line = input.nextLine();
		//System.out.println(line);
		while (input.hasNextLine()) {
			String line2 = input.nextLine();
			System.out.println(line2);
		}

	}

}
