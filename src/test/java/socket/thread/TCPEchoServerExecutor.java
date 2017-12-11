package socket.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class TCPEchoServerExecutor {

    public static void main(String[] args) throws IOException {
        int serverPort = 9998;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        Logger logger = Logger.getLogger("practical");

        Executor service = Executors.newCachedThreadPool();
        while (true) {
            Socket socket = serverSocket.accept();
            service.execute(new EchoProtocol(socket, logger));
        }
    }
}
