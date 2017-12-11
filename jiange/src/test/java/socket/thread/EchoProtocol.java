package socket.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class EchoProtocol implements Runnable {

    private static final int BUFSIZE = 32;
    private Socket clnStock;
    private Logger logger;

    public EchoProtocol(Socket clnStock, Logger logger) {
        this.clnStock = clnStock;
        this.logger = logger;
    }

    public static void handleEchoClient(Socket clnStock, Logger logger) {
        try {
            InputStream in = clnStock.getInputStream();
            OutputStream out = clnStock.getOutputStream();

            int recvMsgSize;
            int totalBytesEchoed = 0;
            byte[] echoBuffer = new byte[BUFSIZE];
            while ((recvMsgSize = in.read(echoBuffer)) != -1) {
                out.write(echoBuffer, 0, recvMsgSize);
                totalBytesEchoed += recvMsgSize;
            }
            logger.info("Client " + clnStock.getRemoteSocketAddress() + " , echoed " + totalBytesEchoed + " bytes. ");
        } catch (IOException e) {
            logger.warning("Exception in echo protocol");
        } finally {
            try {
                clnStock.close();
            } catch (IOException e) {
                logger.warning("Client close exception");
            }
        }
    }

    @Override
    public void run() {
        handleEchoClient(clnStock, logger);
    }
}
