package struct.huff;

import java.util.ArrayList;
import java.util.LinkedList;

import org.w3c.dom.NodeList;

import lombok.Getter;
import lombok.Setter;

public class HuffmanTree {
	@Setter
	@Getter
	private Node root;
	@Setter
	@Getter
	private HuffCode<Integer, Integer> huff;
	
	public HuffmanTree(Node node,HuffCode<Integer, Integer> code){
		this.root = node;
		this.huff = code;
	}
	
	public void createTree(SortedList<Node> nodeList){
		while(true){
			Node first = nodeList.get(0);
			nodeList.remove(0);
			Node root = first;
			if(nodeList.size() <= 0){
				this.root = root;
				break;
			}
			Node second = nodeList.get(0);
			if(second != null){
				nodeList.remove(0);
				Node firstRoot = new Node();
				firstRoot.setLeft(first);
				firstRoot.setRight(second);
				firstRoot.setWeight(first.getWeight() + second.getWeight());
				nodeList.insertItem(firstRoot);
			}
		}
	}
	
	public void show(Node node , int codeValue){
		if(node.getLeft() != null){
			this.huff.put(codeValue, 0);
			show(node.getLeft(), codeValue+1);
		}
		
		if(node.getObject() != null){
			System.out.println("Weight = "+node.getWeight() + ", Huffman code value = " +this.huff.toString().substring(0, codeValue));
			
		}
		
		if(node.getRight() != null){
			this.huff.put(codeValue, 1);
			show(node.getRight(), codeValue+1);
		}
	}


}
