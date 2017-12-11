package socket.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class TCPEchoServerThread {
    public static void main(String[] args) throws IOException {
        int serverport = 9999;
        ServerSocket serverSocket = new ServerSocket(serverport);
        Logger logger = Logger.getLogger("practical");

        while (true) {
            Socket clnStock = serverSocket.accept();
            Thread thread = new Thread(new EchoProtocol(clnStock, logger));
            thread.start();
            logger.info("Created and started Thread " + thread.getName());
        }
    }
}
