import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TestGeometricObject {

	public static void main(String[] args) throws FileNotFoundException{
//		Circle cir1 = new Circle(2.0);
//		cir1.setColor("Red");
//		cir1.setFilled(true);
//		
//		File inputFile = new File("C:\\Users\\Carte\\CSC1061-CFinch\\Polymorphism\\src\\input.txt");
//		Scanner input = new Scanner(inputFile);
//		//String line = input.nextLine();
//		//System.out.println(line);
//		while (input.hasNextLine()) {
//			String line2 = input.nextLine();
//			System.out.println(line2);
		
		
		
		Rectangle rect1 = new Rectangle("black", true, 5, 10);
		Circle circ1 = new Circle("red", true, 11);
		
		Rectangle rect2 = new Rectangle("yellow", true, 4, 9);
		Circle circ2 = new Circle("blue", true, 4.5);
		
		Database db = null;
		try {
			db = new Database();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		try {
			db = new Database();
			db.writeGeometricObject(rect1);
			db.writeGeometricObject(rect2);
			db.writeGeometricObject(circ1);
			db.writeGeometricObject(circ2);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
		try {
			db.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Error while closing writer.");
			System.exit(-1);
		}
		List<GeometricObject> objList = db.readDatabase();
		
		}

	}

//}
