import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LPlotDemo {
	public static ArrayList<Node[][]> grids = new ArrayList<>();
	public static ArrayList<ArrayList<Segment>> segmentLists = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input;
		Algorithms algo = new Algorithms();
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
		
		//tests that grid was created correctly
//		for(int i = 0; i < grids.get(0).length; i++) {
//			for(int j = 0; j < grids.get(0)[i].length; j++) {
//				System.out.print(grids.get(0)[i][j].value);
//			}
//			System.out.println();
//		}
		
		segmentLists.add(algo.findSegments(grids.get(0)));
		
		System.out.println(segmentLists.get(0).size());
		
		for(Segment s : segmentLists.get(0)) {
			for(Node n : s.nodeList) {
				System.out.println(n.row + " " + n.col);
			}
			System.out.println();
		}
		
		
		input.close();
	}

}
