package cn.maxlu.java.learn.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by luwei on 2017/6/1.
 */
public class Server {

    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9001);

        try {
            while (true) {
                //receive data
                byte[] receiveBuffer = new byte[11];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);
                byte[] receiveData = receivePacket.getData();
                System.out.println("receive message:" + new String(receiveData));

                //get client info and send data
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                byte[] sendBuffer = "hello china".getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }

    }
}
