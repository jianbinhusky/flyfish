package struct.huff;

import lombok.Data;

@Data
public class Node implements Comparable<Node> {
	private Object object;
	private Integer weight;
	private Node left;
	private Node right;
	
	@Override
	public int compareTo(Node node) {
		return this.getWeight().compareTo(node.getWeight());
	}
}
