package net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("127.0.0.1", 2312);
		OutputStream out = s.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		pw.write("shello java net !");
		pw.flush();
		pw.close();
		out.close();
		s.close();
	}

}
