package socket.advanced;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class VoteMulticastSender {
    public static final int CANDIDATEID = 475;

    public static void main(String[] args) throws IOException {
        String host = "";
        int destPort = 9889;
        int TTL = 4;
        InetAddress destAddr = InetAddress.getByName(host);
        if (!destAddr.isMulticastAddress()) {
            throw new IllegalArgumentException("Not a multicast address");
        }

        MulticastSocket sock = new MulticastSocket();
        sock.setTimeToLive(TTL);

        //TODO

    }
}
