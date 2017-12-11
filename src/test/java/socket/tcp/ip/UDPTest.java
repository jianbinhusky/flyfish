package socket.tcp.ip;

public class UDPTest {

    public static void main(String[] args) {
//        Thread server1 = new UDPServer();
//        server1.start();
        UDPClient client1 = new UDPClient();
//        client1.send("Good morning!");
        client1.send("stop");
    }
}
