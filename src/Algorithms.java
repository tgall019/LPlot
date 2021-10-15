import java.util.ArrayList;

public class Algorithms {
	
	public static ArrayList<Segment> findSegments(Node[][] grid){
		ArrayList<Segment> list = new ArrayList<>();
		Segment auxSeg;
		
		int adder = 1;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j].value == 1) {
					auxSeg = new Segment();
					
					//try vertical
					while((i + adder) < grid.length && grid[i+adder][j].value == 1) {
						//origin node
						if(adder == 1) {
							auxSeg.add(grid[i][j]);
							grid[i][j].value = 0;
						}
						
						//add node and clear grid
						auxSeg.add(grid[i+adder][j]);
						grid[i+adder][j].value = 0;
						
						adder++;
					}
					list.add(auxSeg);
					
					//reset variables
					auxSeg = new Segment();
					adder = 1;
					
					//try vertical
					while((j + adder) < grid[i].length && grid[i][j+adder].value == 1) {
						//origin node
						if(adder == 1) {
							auxSeg.add(grid[i][j]);
							grid[i][j].value = 0;
						}
						
						//add node and clear grid
						auxSeg.add(grid[i][j+adder]);
						grid[i][j+adder].value = 0;
					}	
					
				}
			}
		}
		
		return list;
	}
}
