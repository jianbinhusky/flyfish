package struct.huff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class SortedList<T extends Node> extends LinkedList<T> {

	/**
	 * Auto generate
	 */
	private static final long serialVersionUID = -3292408426914900661L;
	
	
	public void insertItem(T item){
		int index = 0;
		if(this.size() > 0){
			int start = 0;
			int end = this.size() - 1;
			int step = 0;
			if(start != end){
				while((end - start) != 1){
					step = (end -start) / 2;
					int value = this.get(start + step).getWeight() - item.getWeight();
					if(value > 0){
						end -= step;
					}else if(value < 0){
						start += step;
					}else{
						this.add(start+step, item);
					}
				}
			}
			
			if(item.getWeight() >= this.get(end).getWeight()){
				index = end + 1;
			}else if(item.getWeight() <= this.get(start).getWeight()){
				index = start;
			}else{
				index = end;
			}
		}
		this.add(index, item);
	}
	
	public String toString(){
		String str = "[";
		for (int i = 0; i < this.size(); i++) {
			str += this.get(i).getWeight() + ",";
		}
		str = str.substring(0, str.length() - 1);
		str += "]";
		
		return str;
	}
	
	public static void main(String[] args){
		SortedList<Node> nodeList = new SortedList<Node>();
		LinkedList<Node> list = new LinkedList<Node>();
		ArrayList<Node> arrays = new ArrayList<Node>();
		for (int i = 0; i < 10; i++) {
			int value = (int) (Math.random() * 100);
			System.out.print(value + ",");
			Node node = new Node();
			node.setWeight(value);
			node.setObject(value);
			nodeList.insertItem(node);
			list.add(node);
			arrays.add(node);
		}
		System.out.println();
		for (Node node : nodeList) {
			System.out.print(node.getWeight() + ",");
		}
		System.out.println();
		Collections.sort(list);
		for (Node node : list) {
			System.out.print(node.getWeight() + ",");
		}
		System.out.println();
		System.out.println(nodeList);
		list.remove(0);
		System.out.println(list.get(0).getWeight());
		arrays.remove(0);
		System.out.println(arrays.get(0));
	}
	
}
