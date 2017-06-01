package cn.maxlu.java.learn.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by luwei on 2017/6/1.
 */
public class Server {
    public static void main(String[] args)  throws Exception {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("listening on " + serverSocket.getLocalPort() + "....");
            Socket clientSocket = serverSocket.accept();
            System.out.println("accept connect from " + clientSocket.getRemoteSocketAddress());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("receive message:");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            bufferedWriter.write("hello china");
            bufferedWriter.flush();
            clientSocket.shutdownOutput();//tell client that write finish, or the client will block     notice

            clientSocket.close();
        }
    }

    private static void useDataIOStream() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            System.out.println("listening on " + serverSocket.getLocalPort() + "....");
            Socket clientSocket = serverSocket.accept();
            System.out.println("accept connect from " + clientSocket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            System.out.println("receive message:" + dataInputStream.readUTF() + "\n");

            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            dataOutputStream.writeUTF("Hello China");

            clientSocket.close();
        }
    }
}
