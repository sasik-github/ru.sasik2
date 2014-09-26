package ru.sasik.gui.simple;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8911130270504957765L;
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
