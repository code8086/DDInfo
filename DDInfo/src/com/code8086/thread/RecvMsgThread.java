package com.code8086.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.code8086.desktop.MainWindow;

public class RecvMsgThread extends Thread {
	
	public Socket s;
	
	public void run ()
	{
		try {
			InputStream in = s.getInputStream();
			byte[] buffer = new byte[1024];
			int len ;
			while (true)
			{
				len = in.read(buffer);
				String msg = new String(buffer,0,len,"UTF-8");
				System.out.println(msg);
				MainWindow.msg.append(msg+"\n");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}

}
