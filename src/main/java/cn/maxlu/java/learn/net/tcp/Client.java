package cn.maxlu.java.learn.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by luwei on 2017/6/1.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("127.0.0.1", 9000);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        bufferedWriter.write("hello world");
        bufferedWriter.flush();
        clientSocket.shutdownOutput();//tell server that write finish, or the server will block     notice

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("receive message:");
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        clientSocket.close();
    }

    private static void useDataIOStream() throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 9000);

        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        dataOutputStream.writeUTF("Hello World");

        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
        System.out.println("receive message:" + dataInputStream.readUTF());

        clientSocket.close();
    }
}
