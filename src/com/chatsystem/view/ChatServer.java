package com.chatsystem.view;

import java.io.*;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ServerSocket ss = new ServerSocket(8888);
			while(true){
				Socket s = ss.accept();
System.out.println("A Client Connected!");				
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println(str);
				dis.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
