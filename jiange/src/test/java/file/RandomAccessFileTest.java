package file;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args){
		try {
			RandomAccessFile raf = new RandomAccessFile("/Users/hujianbin/test/a.txt", "rw");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
