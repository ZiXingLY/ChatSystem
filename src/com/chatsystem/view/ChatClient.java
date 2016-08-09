package com.chatsystem.view;

import javax.swing.*;
import java.awt.*;

public class ChatClient extends Frame{
	TextField textField = new TextField();
	TextArea textArea = new TextArea();
	
	public void launchFrame(){
		this.setLocation(400,300);
		this.setSize(300, 300);
		this.add(textField, BorderLayout.SOUTH);
		this.add(textArea, BorderLayout.NORTH);
		pack();
		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient().launchFrame();
	}

}
