import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * TODO: I want to continue prime generating between runs
 * -What if you pass the scanner between runs to continue where you left off?
 * -Is there a way to skip the scanner to a certain line?
 * -Could I mark the last value I used and any other important values if there aren't too many
 * to continue without having to load very value every time I continue?
 */

public class Primes {

	private Scanner loader;
	private ArrayList <Integer> primes;
	private int count = 0;
	
	/**
	 * @author Liam
	 * @param file the file from which primes should be loaded
	 */
	public Primes(File file) {
		
		try {
			
			loader = new Scanner(file);
			primes = new ArrayList<Integer>();
			String line;
			
			while (loader.hasNextLine()) {
				
				line = loader.nextLine();
				primes.add(Integer.parseInt(line));
			}
		}
		catch (FileNotFoundException e) {
			
			System.out.println("File not found.");
			System.out.println(e.getMessage());
		}
		catch (NumberFormatException e) {
			
			System.out.println("Error Parsing.");
			System.out.println(e.getMessage());
		}
		finally {
			
			loader.close();
		}
		
	}
	
	public int getCount() {
		
		return count;
	}
	
	public Scanner getScanner() {
		
		return loader;
	}
}
