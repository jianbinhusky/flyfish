package socket.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class TCPEchoServerPool {

    public static void main(String[] args) throws IOException {
        final int serverPort = 9996;
        int threadPoolSize = 8;
        final ServerSocket serverSocket = new ServerSocket(serverPort);
        final Logger logger = Logger.getLogger("practical");
        for (int i = 0; i < threadPoolSize; i++) {
            Thread thread = new Thread(){
                public void run() {
                    try {
                        Socket clnStock = serverSocket.accept();
                        EchoProtocol.handleEchoClient(clnStock, logger);
                    } catch (IOException e) {
                        logger.warning("Client accpet failed");
                    }
                }
            };
            thread.start();
            logger.info("Created and started Thread = " + thread.getName());
        }
    }
}
