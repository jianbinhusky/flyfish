package socket.tcp.ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer extends Thread {
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];

    public UDPServer() {
        try {
            socket = new DatagramSocket(4445);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        running = true;

        while (running) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                System.out.println("client address --> " + address + "\t" + "port --> " + port);

//                packet = new DatagramPacket(buf, buf.length, address, port);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println(">>>>> " + received);

                if (received.equalsIgnoreCase("stop")) {
                    running = false;
                    continue;
                }

//                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }

    public static void main(String[] args) {
        new UDPServer().start();
    }
}
