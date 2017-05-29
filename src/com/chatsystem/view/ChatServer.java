package com.chatsystem.view;

import java.io.*;
import java.net.*;

public class ChatServer {
	boolean started = false;
	ServerSocket ss = null;
	
	class Client implements Runnable {
		private Socket s;
		private DataInputStream dis = null;
		private DataOutputStream dos=null;
		private boolean bConnected = false;
		
		public Client(Socket s){
			this. s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				bConnected = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			
			// TODO Auto-generated method stub
			try{
				Datab db = new Datab();
				while(bConnected){
					String str = dis.readUTF();
					String name = str.substring(0, str.indexOf('@'));
					String pass = str.substring(str.indexOf('@')+1, str.length());
					if(db.Logindb(name, pass)){
						dos.writeBoolean(true);
					}
					else{
						dos.writeBoolean(false);
					}
				}
			}catch(EOFException e){
				System.out.println("Client Closed!");			
			}catch(Exception e){
				e.printStackTrace();
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
	
	public void start(){
		try{
			started = true;
			ss = new ServerSocket(8888);
			
		}catch(BindException e){
			System.out.println("端口正在被使用！");
			System.out.println("检查端口占用，并重新运行");
			System.exit(0);
		}catch(IOException e){
			e.printStackTrace();
		}
		try{
			while(started){
				Socket s = ss.accept();
				Client c = new Client(s);
System.out.println("A Client Connected!"+s.getInetAddress());	
				new Thread(c).start();
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatServer().start();
	}
	
}
