package com.chatsystem.view;

import java.io.*;
import java.net.*;

public class ChatServer {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean started = false;
		ServerSocket ss = null;
		Socket s = null;
		DataInputStream dis = null;
		try{
			ss = new ServerSocket(8888);
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			started = true;
			while(started){
				boolean bConnected = false;
				s = ss.accept();
System.out.println("A Client Connected!");				
				bConnected = true;
				dis = new DataInputStream(s.getInputStream());
				while(bConnected){
					String str = dis.readUTF();
					System.out.println(str);
				}
//				dis.close();
			}
		}catch(Exception e){
//			e.printStackTrace();
			System.out.println("Client Closed!");
		}finally{
			try {
				if(dis != null) dis.close();
				if(s != null) s.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

}
