package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileTest {

	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fin = new FileInputStream("/Users/hujianbin/test/a.txt");
			FileOutputStream fout = new FileOutputStream("/Users/hujianbin/test/b.txt");
			byte[] buff = new byte[1024];
			int len = 0;
			try {
				while((len = fin.read(buff)) > 0){
					fout.write(buff, 0, len);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				fin.close();
				fout.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
