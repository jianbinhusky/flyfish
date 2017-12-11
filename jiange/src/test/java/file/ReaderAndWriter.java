package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;

public class ReaderAndWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream in = new FileInputStream("/Users/hujianbin/test/a.txt");
		OutputStream out = new FileOutputStream("/Users/hujianbin/test/c.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out);
		StringWriter sw = new StringWriter();
		String s = "hello world ! yeaphet~";
		StringReader sr = new StringReader(s);
		char[] cbuf = new char[1024];
		int len = 0;
		while(( len  = sr.read(cbuf) )!= -1){
			System.out.println(new String(cbuf,0,len));
		}
		InputStreamReader iReader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(iReader);
		BufferedWriter bw = new BufferedWriter(osw);
		while(br.read() != -1){
			System.out.println(br.readLine());
			
		}
		br.close();
		bw.close();
	}

}
