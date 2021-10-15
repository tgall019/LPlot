import java.util.ArrayList;

public class Algorithms {
	
	public static ArrayList<Segment> findSegments(Node[][] grid){
		ArrayList<Segment> list = new ArrayList<>();
		Segment auxSeg;
		
		int adder = 1;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				//values:
//				-	0 -> never valid
//				-	1 -> valid
//				-	2 -> valid to search horizontally
//				-	3 -> valid to search vertically
				if(grid[i][j].value == 1) {
					auxSeg = new Segment();
					adder = 1;
					
					//try vertical
					while((i + adder) < grid.length && grid[i+adder][j].value == 1) {
						//origin node
						if(adder == 1) {
							auxSeg.add(grid[i][j]);
							grid[i][j].value = 2;
						}
						
						//add node and clear grid
						auxSeg.add(grid[i+adder][j]);
						grid[i+adder][j].value = 2;
						
						for(Node n : auxSeg.nodeList) {
							System.out.println(n.row + " " + n.col + "*****");
						}
						System.out.println();
						
						adder++;
					}
					
					//tests each segment's values before inserting it
//					for(Node n : auxSeg.nodeList) {
//						System.out.println(n.row + " " + n.col + "*****");
//					}
//					System.out.println();
					
					if(auxSeg.nodeList.size() > 1)
						list.add(auxSeg);
					
					//reset variables
					auxSeg = new Segment();
					adder = 1;
					
					System.out.println(i + " " + j + "  " + grid[i][j].value + "$$$$$\n");
					
					//try horizontal
					while((j + adder) < grid[i].length && grid[i][j+adder].value == 1) {
						System.out.println("MADE IT");
						
						//origin node
						if(adder == 1) {
							auxSeg.add(grid[i][j]);
							grid[i][j].value = 0;
						}
						
						//add node and clear grid
						auxSeg.add(grid[i][j+adder]);
						grid[i][j+adder].value = 0;
						
						for(Node n : auxSeg.nodeList) {
							System.out.println(n.row + " " + n.col + "#####");
						}
						
						adder++;
					}
					
//					for(Node n : auxSeg.nodeList) {
//						System.out.println(n.row + " " + n.col + "#####");
//					}
					
					System.out.println();					
					if(auxSeg.nodeList.size() > 1)
						list.add(auxSeg);
					
				}
			}
		}
		
		return list;
	}
}
