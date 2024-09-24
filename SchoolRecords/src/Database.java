import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Database {
	private String FILENAME = "PersonDatabase";
	private File file = new File(FILENAME);
	private FileWriter fw;
	private BufferedWriter bw;
	private Scanner scn;

	public Database() throws IOException {
		fw = new FileWriter(FILENAME, true);
		bw = new BufferedWriter(fw);
		scn = new Scanner(file);
		if (!file.exists()) {
			try {
				if (file.createNewFile()) {
					System.out.println("New file created: " + file.getName());
				}
			} catch (IOException e) {
				System.out.println("IOException happened");
			}
		}
	}
	public void writePerson(Person person) throws IOException{
		bw.write(person.toString() + "\n");
		bw.flush();
	}
}
