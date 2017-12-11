package struct.huff;

import java.util.HashMap;

public class HuffCode<K,V> extends HashMap<K, V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8460904566655313714L;
	
	public String toString(){
		String str = "";
		for (int i = 0; i < this.size(); i++) {
			str += this.get(i);
		}
		
		return str;
	}

}
