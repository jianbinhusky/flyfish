package socket.tcp.ip;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPEchoServer {
    private static final int BUFSIZE = 32;

    public static void main(String[] args) {
        int port = 9900;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            int recvMsgSize;
            byte[] receiveBuf = new byte[BUFSIZE];
            while (true) {
//                Socket socket = serverSocket.accept();
                Socket socket = new Socket();
                SocketAddress socketAddress = socket.getRemoteSocketAddress();
                System.out.println("Handling client at " + socketAddress);
//                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String clientStr = "";
                String serverStr = "";
//                while (!serverStr.equalsIgnoreCase("stop")) {
//                    clientStr = in.readUTF();
//                    System.out.println("Client said : " + clientStr);
//                    serverStr = br.readLine();
//                    out.writeUTF(serverStr);
//                    out.flush();
//                }
                do {
                    serverStr = br.readLine();
                    out.writeUTF(serverStr);
                    out.flush();
                    clientStr = in.readUTF();
                    System.out.println("Client said : " + clientStr);
                } while (!serverStr.equalsIgnoreCase("stop"));

                out.close();
                in.close();
                socket.close();
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
