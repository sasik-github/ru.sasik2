package ru.sasik.gui.objects.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ru.sasik.gui.objects.IMainFrame;

public class MainMenu extends JMenuBar {

	private static final long serialVersionUID = 7315824184809695830L;
	private IMainFrame mainFrame;
	private ActionListener fileChooserAction;

	public MainMenu(IMainFrame frame) {
		mainFrame = frame;
		initActions();
		initComponents();
	}

	private void initComponents() {
		JMenu menu = new JMenu("File");
		JMenuItem itm = new JMenuItem("New");
		// itm.addActionListener(actionListener);
		menu.add(itm);

		itm = new JMenuItem("Open");
		menu.add(itm);
		itm.addActionListener(fileChooserAction);

		itm = new JMenuItem("Save");
		itm.addActionListener(fileChooserAction);
		menu.add(itm);

		itm = new JMenuItem("Close");
		// itm.addActionListener(actionListener);
		menu.add(itm);

		add(menu);

		menu = new JMenu("Edit");

		itm = new JMenuItem("copy");
		// itm.addActionListener(actionListener);
		menu.add(itm);

		itm = new JMenuItem("Properties");
		itm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PropertiesChanger(mainFrame);

			}
		});

		menu.add(itm);

		add(menu);
	}
	
	public void initActions() {
		fileChooserAction = new FileChooserAction(mainFrame);
	}

}
