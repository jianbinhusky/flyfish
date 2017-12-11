package socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    private static final int ECHOMAX = 255;

    public static void main(String[] args) throws IOException, InterruptedException {
        int serverPort = 9999;

        DatagramSocket socket = new DatagramSocket(serverPort);
        DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);

        while (true) {
            socket.receive(packet);
            System.out.println("Handling client at " + packet.getAddress().getHostAddress() + " on port " + packet.getPort()
                    + "\t" + ": " + new String(packet.getData(), 0, packet.getLength()));
            Thread.sleep(10000);
            socket.send(packet);
            packet.setLength(ECHOMAX);

        }
    }
}
