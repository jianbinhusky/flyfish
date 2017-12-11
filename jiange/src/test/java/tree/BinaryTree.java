package tree;

import java.util.Stack;

public class BinaryTree {
	
	public Node init(){
		Node i = new Node(8, null, null);
		Node h = new Node(4, null, null);
		Node g = new Node(2, null, null);
		Node f = new Node(7, null, i);
		Node e = new Node(5, h, null);
		Node d = new Node(1, null, g);
		Node c = new Node(9, f, null);
		Node b = new Node(3, d, e);
		Node a = new Node(6, b, c);
		
		return a;
	}
	
	public void printNode(Node node){
		System.out.print(node.getData() + " ");
	}
	
	/**
	 * 先序递归
	 * @param node
	 */
	public void preOrderTraversalRecursive(Node node){
		printNode(node);
		if(node.getLeftNode() != null){
			preOrderTraversalRecursive(node.getLeftNode());
		}
		if(node.getRightNode() != null){
			preOrderTraversalRecursive(node.getRightNode());
		}
	}
	
	/**
	 * 中序递归
	 * @param node
	 */
	public void inOrderTraversalRecursive(Node node){
		if(node.getLeftNode() != null){
			inOrderTraversalRecursive(node.getLeftNode());
		}
		printNode(node);
		if(node.getRightNode() != null){
			inOrderTraversalRecursive(node.getRightNode());
		}
	}
	
	/**
	 * 后序递归
	 * @param node
	 */
	public void postOrderTraversalRecursive(Node node){
		if(node.getLeftNode() != null){
			postOrderTraversalRecursive(node.getLeftNode());
		}
		if(node.getRightNode() != null){
			postOrderTraversalRecursive(node.getRightNode());
		}
		printNode(node);
	}
	
	/**
	 * 非递归先序
	 * @param root
	 */
	public void preOrderTraversalNonRecursive(Node root){
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(node != null || stack.size() > 0){
			if(node != null ){
				printNode(node);
				stack.push(node);
				node = node.getLeftNode();
			} else{
				node = stack.pop();
				node = node.getRightNode(); 
			}
		}
	}
	
	/**
	 * 非递归中序
	 * @param root
	 */
	public void inOrderTraversalNonRecursive(Node root){
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(node != null || stack.size() > 0){
			if(node != null){
				stack.push(node);
				node = node.getLeftNode();
			}else{
				node = stack.pop();
				printNode(node);
				node = node.getRightNode();
			}
		}
	}
	
	/**
	 * 非递归后序
	 * @param root
	 */
	public void postOrderTraversalNonRecursive(Node root){
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> output = new Stack<Node>();
		Node node = root;
		while(node != null || stack.size() > 0){
			if(node != null){
				output.push(node);
				stack.push(node);
				node = node.getRightNode();
			}else{
				node = stack.pop();
				node = node.getLeftNode();
			}
		}
		while(output.size() > 0){
			printNode(output.pop());
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Node node = bt.init();
		
		System.out.print("递归先序 ");
		bt.preOrderTraversalRecursive(node);
		System.out.println();
		
		System.out.print("递归中序 ");
		bt.inOrderTraversalRecursive(node);
		System.out.println();
		
		System.out.print("递归后序 ");
		bt.postOrderTraversalRecursive(node);
		System.out.println();
		
		System.out.print("非递归先 ");
		bt.preOrderTraversalNonRecursive(node);
		System.out.println();
		
		System.out.print("非递归中 ");
		bt.inOrderTraversalNonRecursive(node);
		System.out.println();
		
		System.out.print("非递归后 ");
		bt.postOrderTraversalNonRecursive(node);
		System.out.println();
	}

}
