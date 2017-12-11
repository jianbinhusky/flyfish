package net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class MyThread2 implements Runnable {
	private Socket socket;
	
	public  MyThread2(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			OutputStream out = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(out);
			pw.write("now date is "+new Date());
			pw.flush();
			pw.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
