import java.io.*;

public class Main {

	public static void main(String[] args) throws java.lang.Exception {
		//Declare variables
		BufferedReader br;
		String fileLocation, fileToBe;
		String[] values;
		Reader reader;
		Writer writer;
		
		//Prompt user for a file location
		System.out.println("Enter a file location. \n -Example: C:\\Documents\\Dev\\Workspace\\Planet\\text.txt");
		System.out.print("File: ");
		br = new BufferedReader (new InputStreamReader(System.in));
		fileLocation = br.readLine();
		
		//Create reader with file location
		reader = new Reader(fileLocation);
		
		//Parse file into array
		values = reader.parseText();
		
		//Prompt user for new file name
		System.out.println("What would you like to name your new file?");
		fileToBe = br.readLine();
		
		//Create writer based on parsed values and new file name, then print
		writer = new Writer(values, fileToBe);
		writer.printFile();
		System.out.println("Thank you, your file '" + fileToBe + "' has been created.");
	}
}
