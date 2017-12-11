package struct.huff;

public class TestHuff {

	public static void main(String[] args) {
		SortedList<Node> nodeList = new SortedList<Node>();
		for (int i = 0; i < 5; i++) {
			int value = (int) (Math.random() * 100);
			System.out.print(value + ",");
			Node node = new Node();
			node.setWeight(value);
			node.setObject(value);
			nodeList.insertItem(node);
		}
		HuffmanTree ht = new HuffmanTree(new Node() , new HuffCode<Integer, Integer>());
		ht.createTree(nodeList);
		System.out.println();
		System.out.println("###############");
		ht.show(ht.getRoot() , 0);
	}

}
