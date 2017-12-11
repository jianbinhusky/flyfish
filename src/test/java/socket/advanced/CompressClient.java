package socket.advanced;

import java.io.*;
import java.net.Socket;

public class CompressClient {
    public static final int BUFSIZE = 256;

    public static void main(String[] args) throws IOException {
        String server = "127.0.0.1";
        int port = 9998;
        String filename = "C:\\Users\\hujb4\\Downloads\\coc.txt";
        FileInputStream fileIn = new FileInputStream(filename);
        FileOutputStream fileOut = new FileOutputStream(filename + ".gz");

        Socket socket = new Socket(server, port);

        sendBytes(socket, fileIn);

        InputStream sockIn = socket.getInputStream();
        int byteRead;
        byte[] buffer = new byte[BUFSIZE];
        while ((byteRead = sockIn.read(buffer)) != -1) {
            fileOut.write(buffer, 0, byteRead);
            System.out.println("R");
        }
        System.out.println();
        socket.close();
        fileIn.close();
        fileOut.close();

    }

    private static void sendBytes(Socket socket, InputStream fileIn) throws IOException {
        OutputStream sockOut = socket.getOutputStream();
        int byteRead;
        byte[] buffer = new byte[BUFSIZE];
        while ((byteRead = fileIn.read()) != -1) {
            sockOut.write(buffer, 0, byteRead);
            System.out.println("W");
        }
        socket.shutdownOutput();
    }

}
