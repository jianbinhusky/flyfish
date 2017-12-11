package socket.nio;

import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class TCPServerSelector {

    private static final int BUFSIZE = 256;

    private static final int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException {
        String[] ports = {"8123","8124","8125"};
        Selector selector = Selector.open();
        for (String arg : ports) {
            ServerSocketChannel listnChannel = ServerSocketChannel.open();
            listnChannel.socket().bind(new InetSocketAddress(Integer.parseInt(arg)));
            listnChannel.configureBlocking(false);
            listnChannel.register(selector, SelectionKey.OP_ACCEPT);
        }

        TCPProtocol protocol = new EchoSelectorProtocol(BUFSIZE);

//        while (true) {
//            if (selector.select(TIMEOUT) == 0) {
//                System.out.println(".");
//                continue;
//            }
//            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
//            while (keyIter.hasNext()) {
//                SelectionKey key = keyIter.next();
//                if (key.isAcceptable()) {
//                    protocol.handleAccept(key);
//                }
//
//                if (key.isReadable()) {
//                    protocol.handleRead(key);
//                }
//
//                if (key.isValid() && key.isWritable()) {
//                    protocol.handleWrite(key);
//                }
//                keyIter.remove();
//            }
//        }
        Double price = 612959.00;
        String str = StringUtils.trimToEmpty(price.toString());
        System.out.println(str);

        System.out.println(str.replaceAll(".0",""));

        System.out.println(str.split("\\.")[0]);

    }
}
