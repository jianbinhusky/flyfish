package net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClientTest {

	public static void main(String[] args) throws IOException {
		DatagramSocket ds = new DatagramSocket(6358);
		String str = "datagram udp socket!";
		DatagramPacket dp = new DatagramPacket(str.getBytes(), 0, str.length(), InetAddress.getByName("127.0.0.1"),2312);
		ds.send(dp);
		ds.close();
	}

}
