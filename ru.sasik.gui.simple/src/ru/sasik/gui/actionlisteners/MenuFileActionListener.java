package ru.sasik.gui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFileActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("MenuFileActionListener.actionPerformed()" + e.getActionCommand());
		
	}

}
