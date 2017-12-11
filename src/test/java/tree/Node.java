package tree;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Node implements Comparable<Node> , Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8308010015965363860L;
	@Setter
	@Getter
	private int data;
	@Setter
	@Getter
	private Node leftNode;
	@Setter
	@Getter
	private Node rightNode;
	
	public Node(int data , Node leftNode , Node rightNode){
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
