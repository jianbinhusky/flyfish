package socket.udp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.*;

public class UDPEchoClientTimeout {
    private static final int TIMEOUT = 3000;
    private static final int MAXTRIES = 5;

    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress serverAddress = InetAddress.getByName("localhost");
        String msg = "Great Job!";
        byte[] bytesToSend = msg.getBytes();
        int serverPort = 9999;

        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(TIMEOUT);
        DatagramPacket sendPacket = new DatagramPacket(bytesToSend, bytesToSend.length, serverAddress, serverPort);
        DatagramPacket receivePacket = new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);
        int tries = 0;
        boolean receivedResponse = false;
        do {
            try {
                socket.send(sendPacket);
                socket.receive(receivePacket);
                if (!receivePacket.getAddress().equals(serverAddress)) {
                    throw new IOException("Received packet from an unknow source.");
                }
                receivedResponse = true;
            } catch (InterruptedIOException e) {
                tries += 1;
                System.out.println("Timed out, " + (MAXTRIES - tries) + " more tries...");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } while ((!receivedResponse) && (tries < MAXTRIES));
        if (receivePacket.getAddress() != null && receivePacket.getLength() > 0) {
            System.out.println("Received msg from " + receivePacket.getAddress().getHostAddress() + " on port " + receivePacket.getPort()
                    + "\t" + ": " + new String(receivePacket.getData(), 0, receivePacket.getLength()));
        } else {
            System.out.println("Timed out and after 5 tries could not receive yet.");
        }
    }
}
