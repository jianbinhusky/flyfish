package collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class TestMap {
	
	public static void main(String[] args){
		HashMap<String, String> h1 = new HashMap<String, String>(); 
		Hashtable<String, String> h2 = new Hashtable<String, String>();
		ConcurrentHashMap<String, String>  h3 = new ConcurrentHashMap<String, String>();
	}

}
