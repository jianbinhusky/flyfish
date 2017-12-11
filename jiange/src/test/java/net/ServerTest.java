package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(2312);
		Socket s = ss.accept();
		InputStream in = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(in); 
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
		in.close();
		s.close();
		ss.close();
	}
}
