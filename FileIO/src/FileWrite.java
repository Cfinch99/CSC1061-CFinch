import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//other file io stuff can be found under polymorphism projects

public class FileWrite {

	public static void main(String[] args) throws IOException{
		File myFile = new File("kmfilewrite.txt");
		if(!myFile.exists()) {
			try {
				if(myFile.createNewFile()){
					System.out.println("New file created: " + myFile.getName());
				}
			}
			catch (IOException e){
				System.out.println("IOException happened");
				
			}
		}
		
		FileWriter fileWriter = new FileWriter(myFile.getName(), false);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		bw.write("The moon is made of cheese");
		bw.flush();
		fileWriter.close();
		
		
		//fileWriter.flush();
		//fileWriter.close();
	}
}
