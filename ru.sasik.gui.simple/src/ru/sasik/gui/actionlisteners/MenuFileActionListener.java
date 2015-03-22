package ru.sasik.gui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.sasik.gui.objects.IMainFrame;

public class MenuFileActionListener implements ActionListener{

	private IMainFrame mainFrame;

	public MenuFileActionListener(IMainFrame mainFrame) {
		this.mainFrame = mainFrame; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("MenuFileActionListener.actionPerformed()" + e.getActionCommand());
		
	}

}
