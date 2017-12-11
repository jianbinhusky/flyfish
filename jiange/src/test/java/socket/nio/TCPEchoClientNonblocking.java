package socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TCPEchoClientNonblocking {
    public static void main(String[] args) throws IOException {
        String server = "127.0.0.1";
        int servPort = 8123;
        byte[] argument = "How Can I earn more money?".getBytes();

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        if (!socketChannel.connect(new InetSocketAddress((server), servPort))) {
            while (!socketChannel.finishConnect()) {
                System.out.println(".");
                System.out.println("do something else");
            }
        }
        ByteBuffer writeBuf = ByteBuffer.wrap(argument);
        ByteBuffer readBuf = ByteBuffer.allocate(argument.length);
        int totalBytesRcvd = 0;
        int bytesRcvd;
        while (totalBytesRcvd < argument.length) {
            if (writeBuf.hasRemaining()) {
                socketChannel.write(writeBuf);
            }
            if ((bytesRcvd = socketChannel.read(readBuf)) == -1) {
                throw new SocketException("Connection closed prematurely");
            }
            totalBytesRcvd += bytesRcvd;
            System.out.println("do other things.");
        }

        System.out.println("Received: " + new String(readBuf.array(), 0, totalBytesRcvd));
        socketChannel.close();
    }
}
