package file;

import java.io.File;
import java.io.IOException;

public class TestFileHandle {

	public static void main(String[] args) {
		File dir = new File("/Users/hujianbin/test");
		if(!dir.exists()){
			dir.mkdir();
		}
		
		if(dir.isDirectory()){
			System.out.println("isDirectory !");
		}
		
		String[] files = dir.list();
		System.out.println("total file number is "+files.length);
		for (String string : files) {
			System.out.println("file: "+string);
		}
		
		File fileA = new File("/Users/hujianbin/test/a.txt");
		if(!fileA.exists()){
			try {
				fileA.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("a.txt length is "+fileA.length());
			System.out.println("a.txt absolute path is "+fileA.getAbsolutePath());
			System.out.println("a.txt absolute file is "+fileA.getAbsoluteFile());
		}
	}

}
