import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
	private String fileName = "database.csv";
	private File file = new File(fileName);
	private FileWriter fw;
	private BufferedWriter bw;
	private Scanner scn;
	
	
	public Database() throws IOException{
		fw = new FileWriter(fileName, true);
		bw = new BufferedWriter(fw);
		scn = new Scanner(file);
	}
	
	public void writeGeometricObject(GeometricObject obj) throws IOException {

		// common properties between circle and rectangle
		// comma separated value value or .csv
		// add newlines to make it correctly export
		bw.write(obj.getClass().getName() + "," + (obj.getColor() + "," + obj.isFilled()));
		
		if(obj instanceof Rectangle) {
			Rectangle robj = (Rectangle)obj;
			bw.write("," + robj.getWidth() + "," + robj.getHeight() + "\n");
		}
		
		// cast obj to circle and add circle values, same above but with rectangle
		if (obj instanceof Circle) {
			Circle cobj = (Circle)obj;
			bw.write("," + cobj.getRadius() + "\n");
		}
		
		
		
	}
	
	public List<GeometricObject> readDatabase(){
		List <GeometricObject> list = new ArrayList<>();
		while(scn.hasNextLine()) {
			String line = scn.nextLine();
			String[] tokens = line.split(",");
			GeometricObject obj = null;
			if(tokens[0].equals("Rectangle")) {
				obj = new Rectangle(tokens[1], Boolean.valueOf(tokens[2]),
						Double.valueOf(tokens[3]), Double.valueOf(tokens[4]));
			}
			else if(tokens[0].equals("Circle")) {
				obj = new Circle(tokens[1], Boolean.valueOf(tokens[2]),
						Double.valueOf(tokens[3]));
			}
			list.add(obj);
		}
		return list;
		
	}
	public void close() throws IOException {
		bw.close();
		fw.close();
	}

}
