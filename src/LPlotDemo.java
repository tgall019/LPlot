import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LPlotDemo {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input;
		try {
			File inputFile = new File("input.txt");
			input = new Scanner(inputFile);
		}
		catch(FileNotFoundException e) {
			throw(e);
		}
		
		
		System.out.println(input.nextInt());
		input.close();
	}

}
