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
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
