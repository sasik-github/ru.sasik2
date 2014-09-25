package ru.sasik.gui.simple;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	
	private JLabel msg;
	
	public StatusBar() {
		msg = new JLabel("Status bar");
		add(msg);
		setVisible(true);
	}
	
	public void setText(String text) {
		msg.setText(text);
	}
	

}
