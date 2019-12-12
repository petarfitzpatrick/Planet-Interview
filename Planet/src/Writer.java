import java.io.*;

public class Writer {
	//Declare variables
	private String[] values;
	private String fileToBe;
	
	//Constructor
	public Writer(String[] a, String b) {
		values = a;
		fileToBe = b;
	}
	
	//Format values and create a new file
	public void printFile() throws IOException {
		FileWriter fileWriter = new FileWriter(fileToBe);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		//Incremented by 9 because each person has 9 unique values
		int indexPeople = 1;
		for (int i = 0; i < values.length; i+=9) {
			//Try and Catch ArrayIndexOutOfBoundsException for incomplete files 
			try {
			printWriter.println(indexPeople);
			printWriter.println("  " + values[i] +" " + values[i+1] + "," + " (" + dateBuilder(values[i+2]) + ")");
			printWriter.println("  " + values[i+3] + "," + "  " + values[i+4] + ",");
			printWriter.println("  " + values[i+5] + "," + " " + values[i+6] + ",");
			printWriter.println("  " + values[i+7] + "," + " " + values[i+8]);
			indexPeople++;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("WARNING: File is incomplete.");
			}
		}
		printWriter.close();
	}
	
	//Format 8 digit date into a readable MM/DD/YYYY format. Creates an empty String for incorrect/missing values
	private String dateBuilder(String date) {
		String result = "";
		if (date.length() == 8) {
		result = date.substring(4, 6) + "/" + date.substring(6, 8) + "/" + date.substring(0, 4);
		}
		return result;
	}
}
