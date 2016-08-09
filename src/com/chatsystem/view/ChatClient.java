package com.chatsystem.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {
	TextField textField = new TextField();
	TextArea textArea = new TextArea();

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
				System.exit(0);
			}
			
		});
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient().launchFrame();
	}

}
