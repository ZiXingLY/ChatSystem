package com.chatsystem.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
		textField.addActionListener(new TFListener());
		this.setVisible(true);
		
	}
	
	private class TFListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String s = textField.getText().trim();//trim()È¥¿Õ¸ñ
			textArea.setText(s);
			textField.setText("");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClient().launchFrame();
	}

}
