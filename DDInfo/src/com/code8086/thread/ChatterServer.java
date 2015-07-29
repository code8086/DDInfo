package com.code8086.thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import com.code8086.desktop.MainWindow;

public class ChatterServer extends Thread {
    static final int INPORT = 8848;
    private byte[] buf = new byte[1000];
    private DatagramPacket dp = new DatagramPacket(buf, buf.length);
    private DatagramSocket socket;

    public ChatterServer() {
        
    }
    
    public void run ()
    {
    	try {
            socket = new DatagramSocket(INPORT);// 创建一接收消息的对象，而不是每次接收消息都创建一个
            System.out.println("Server started");
            MainWindow.msg.append("Server started\n");
            while (true) {
                socket.receive(dp);
                //接收到客户端的消息
                //String rcvd = Dgram.toString(dp) + ",from address:" + dp.getAddress() + ",port:" + dp.getPort();
                
                String rcvd = Dgram.toString(dp);
                
                System.out.println("From Client:"+rcvd);
                MainWindow.msg.append(rcvd+"\n");
                
                String echoString = "From Server Echoed:" + rcvd;
                DatagramPacket echo = Dgram.toDatagram(echoString,
                        dp.getAddress(), dp.getPort());
                //将数据包发送给客户端
                socket.send(echo);
            }
        } catch (SocketException e) {
            System.err.println("Can't open socket");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Communication error");
            e.printStackTrace();
        }
    }
    
}

