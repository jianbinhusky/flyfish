package socket.tcp.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class UDPClient {
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf;

    public UDPClient() {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String send(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
        try {
            socket.send(packet);
            packet = new DatagramPacket(buf, buf.length);
//            socket.receive(packet);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String received = new String(packet.getData(), 0, packet.getLength());
        return  received;
    }

    public void close() {
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = "";
        UDPClient client = new UDPClient();
        while (!msg.equalsIgnoreCase("stop")) {
            msg = br.readLine();
            new UDPClient().send(msg);
        }
        client.close();
    }
}
