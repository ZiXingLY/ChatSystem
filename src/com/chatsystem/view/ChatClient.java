package com.chatsystem.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient extends Frame {
	TextField textField = new TextField();
	TextArea textArea = new TextArea();
	Socket s = null;
	DataOutputStream  dos = null;

	public void launchFrame() {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.add(textField, BorderLayout.SOUTH);
		this.add(textArea, BorderLayout.NORTH);
		pack();
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				disconnect();
				System.exit(0);
			}
			
		});
		textField.addActionListener(new TFListener());
		this.setVisible(true);
		connect();
	}
	
	private class TFListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = textField.getText().trim();//trim()È¥¿Õ¸ñ
			textArea.setText(str);
			textField.setText("");
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public void connect(){
		try {
			s = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(s.getOutputStream());
System.out.println("Connected!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		try {
			dos.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient().launchFrame();
	}

}
