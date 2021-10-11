import java.util.ArrayList;

public class Segment{
	public static ArrayList<Node> nodeList = new ArrayList<>();
	private char direction;
	
	public void setDirection() {
		if(nodeList.size() > 1) 
			if(nodeList.get(0).row == nodeList.get(1).row)
				direction = 'h';
	}
	
	//adds node to segment
	public void add(Node node) {
		nodeList.add(node);
	}
	
	// finds and sets the endpoint of the segment
	public void setEndpoint() {
		if(nodeList.size() > 1) {
			nodeList.get(0).isEndNode = true;
			nodeList.get(nodeList.size() - 1).isEndNode = true;
		}
	}
}
