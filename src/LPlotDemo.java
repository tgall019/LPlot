import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LPlotDemo {
	private static ArrayList<Node[][]> grids = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input;
		try {
			File inputFile = new File("input.txt");
			input = new Scanner(inputFile);
		}
		catch(FileNotFoundException e) {
			throw(e);
		}
		
		//filter input and create data structure
		int gridCount = input.nextInt();
		for(int k = 0; k < gridCount; k++) {
			int rows = input.nextInt(), cols = input.nextInt();
			Node[][] grid = new Node[rows][cols];
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					grid[i][j] = new Node(i, j, input.nextInt());
				}
			}
			grids.add(grid);
		}
		
		
		input.close();
	}

}
