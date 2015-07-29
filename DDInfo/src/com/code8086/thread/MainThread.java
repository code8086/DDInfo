package com.code8086.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainThread extends Thread
{
	public void run ()
	{
		try {
			ServerSocket listen = new ServerSocket(8848);
			System.out.println("Starting...");
			while (true)
			{
				Socket server = listen.accept();
				RecvMsgThread r = new RecvMsgThread();
				r.s = server;
				r.start();
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
