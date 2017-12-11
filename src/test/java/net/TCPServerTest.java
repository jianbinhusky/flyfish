package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerTest {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(2312);
		Socket s = null;
		while((s = ss.accept()) != null){
//			new MyThread1(s).start();
			Thread t = new Thread(new MyThread2(s)); 
			t.start();
		}
		ss.close();
	}

}
