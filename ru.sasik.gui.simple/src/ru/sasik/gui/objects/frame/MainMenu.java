package ru.sasik.gui.objects.frame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu extends JMenuBar {
	
	private static final long serialVersionUID = 7315824184809695830L;

	public MainMenu() {
		initComponents();
	}

	private void initComponents() {
		JMenu menu = new JMenu("File");
		JMenuItem itm = new JMenuItem("New");
//		itm.addActionListener(actionListener);
		menu.add(itm);

		itm = new JMenuItem("Open");
		menu.add(itm);
//		itm.addActionListener(fileChooserAction);

		itm = new JMenuItem("Save");
//		itm.addActionListener(fileChooserAction);
		menu.add(itm);

		itm = new JMenuItem("Close");
//		itm.addActionListener(actionListener);
		menu.add(itm);

		add(menu);

		menu = new JMenu("Edit");

		itm = new JMenuItem("copy");
//		itm.addActionListener(actionListener);
		menu.add(itm);
		
		itm = new JMenuItem("Properties");
		menu.add(itm);

		add(menu);
	}
	
	
}
