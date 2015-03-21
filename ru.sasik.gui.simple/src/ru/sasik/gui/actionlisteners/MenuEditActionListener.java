package ru.sasik.gui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEditActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("MenuEditActionListener.actionPerformed()" + e.getActionCommand());
	}

}
