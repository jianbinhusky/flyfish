package socket.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeLimitEchoProtocol implements Runnable {

    private static final int BUFSIZE = 32;
    private static final String TIMELIMIT = "10000";
    private static final String TIMELIMITPROP = "Timelimit";
    private static int timelimit;
    private Socket clnSock;
    private Logger logger;

    public TimeLimitEchoProtocol(Socket clnSock, Logger logger) {
        this.clnSock = clnSock;
        this.logger = logger;
        timelimit = Integer.parseInt(System.getProperty(TIMELIMITPROP,TIMELIMIT));
    }

    public static void handleEchoClient(Socket clnSock, Logger logger) {
        try {
            InputStream in = clnSock.getInputStream();
            OutputStream out = clnSock.getOutputStream();
            int recvMsgSize;
            int totalBytesEchoed = 0;
            byte[] echoBuffer = new byte[BUFSIZE];
            long endTime = System.currentTimeMillis() + timelimit;
            int timeBoundMillis = timelimit;
            clnSock.setSoTimeout(timeBoundMillis);
            while ((timeBoundMillis > 0) && ((recvMsgSize = in.read()) != -1)) {
                out.write(echoBuffer, 0, recvMsgSize);
                totalBytesEchoed += recvMsgSize;
                timeBoundMillis = (int) (endTime - System.currentTimeMillis());
                clnSock.setSoTimeout(timeBoundMillis);
            }
            logger.info("Client " + clnSock.getRemoteSocketAddress() + ", echoed " + totalBytesEchoed + "bytes.");
        } catch (IOException e) {
            logger.log(Level.WARNING, "Exception in echo protocol", e);
        }
    }

    @Override
    public void run() {
        handleEchoClient(this.clnSock, this.logger);
    }
}
