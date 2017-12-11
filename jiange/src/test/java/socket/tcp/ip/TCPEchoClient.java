package socket.tcp.ip;

import java.io.*;
import java.net.Socket;

public class TCPEchoClient {

    public static void main(String[] args) throws IOException {
        final String server = "127.0.0.1";
        final int port = 9900;
        String data = "TCP/IP Socket Client";
//        for (int i = 0; i < 50000; i++) {
//            System.out.println(i);
//            new Thread(){
//                @Override
//                public void run() {
                    try {
                        Socket socket = new Socket(server, port);
                        DataInputStream in = new DataInputStream(socket.getInputStream());
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                        String clientStr = "";
                        String serverStr = "";
                        while (!clientStr.equalsIgnoreCase("stop")) {
                            serverStr = in.readUTF();
                            System.out.println("Server said : " + serverStr);
                            clientStr = br.readLine();
                            out.writeUTF(clientStr);
                            out.flush();
                        }
                        br.close();
                        in.close();
                        out.close();
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                }
//            }.start();
//        }
    }
}
