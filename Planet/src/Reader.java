import java.util.*;
import java.io.*;

public class Reader {
	//Declare variables
	private File file;
	private List<String> values = new ArrayList<String>();
	private String[] items;
	private Scanner sc;
	private BufferedReader br;
	
	//Constructor
	public Reader(String a) {
		file = new File(a);
	}
	
	//Check if the file exists and isn't a directory
	private Boolean checkValid() {
		if (file.isFile()) {
			return true;
		} else {
			return false;
		}
	}
	
	//Parse values into an ArrayList, then convert them into an array
	public String[] parseText() throws IOException{
		//Try and Catch FileNotFoundException
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			//While the file is invalid, prompt for new ones
			while (!checkValid()) {
				br = new BufferedReader (new InputStreamReader(System.in));
				System.out.println("INVALID FILE LOCATION.");
				System.out.println("Enter a file location. \n -Example: C:\\Documents\\Dev\\Workspace\\Planet\\text.txt");
				System.out.print("File: ");
				file = new File(br.readLine());
			}
			sc = new Scanner(file);
		} finally {
			//Parse values separated by commas and new lines, then add to the ArrayList
			sc.useDelimiter(",|\\n");
			String inputType = sc.next();
			//Check which input type is on the first line
			if (inputType.contains("1")) {
				parseOne();
			} else if (inputType.contains("2")){
				parseTwo();
			} else {
				System.out.println("Invalid File Type");
			}
		}
		//Close the Scanner
		sc.close();
		return items;
	}
	
	//Parse file based on first file type
	private String[] parseOne() {
		while (sc.hasNext()) {
			//Try and Catch StringIndexOutOfBoundsException
			try {
			values.add(sc.next().substring(0, 80));
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("WARNING: Input file is incomplete.");
			}
		}
		//Initialize items array by amount of lines*data values
		items = new String[values.size()*9];
		int counter = 0;
		
		//Add values based on appropriate substring values
		for (int i = 0; i < items.length; i+=9) {
			items[i] = values.get(counter).substring(0, 10).trim();
			items[i+1] = values.get(counter).substring(10, 27).trim();
			items[i+2] = values.get(counter).substring(27, 35).trim();
			items[i+3] = values.get(counter).substring(35, 45).trim();
			items[i+4] = values.get(counter).substring(45, 55).trim();
			items[i+5] = values.get(counter).substring(55, 65).trim();
			items[i+6] = values.get(counter).substring(65, 67).trim();
			items[i+7] = values.get(counter).substring(67, 70).trim();
			items[i+8] = values.get(counter).substring(70, 80).trim();
			counter++;
		}
		return items;
	}
	
	//Parse file based on second file type
	private String[] parseTwo() {
		while (sc.hasNext()) {
			values.add(sc.next());
		}
		items = new String[values.size()];
		//Since the ArrayList was parsed by commas, this is much simpler
		for (int i = 0; i < items.length; i++) {
			items[i] = values.get(i);
		}
		return items;
	}
}