package socket.advanced;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class VoteMulticastReceiver {

    public static void main(String[] args) throws IOException {
        String host = "";
        int port = 9889;
        InetAddress address = InetAddress.getByName(host);
        if (!address.isMulticastAddress()) {
            throw new IllegalArgumentException("Not a multicast address");
        }

        MulticastSocket sock = new MulticastSocket(port);
        sock.joinGroup(address);
    }
}
