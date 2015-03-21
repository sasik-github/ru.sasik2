package ru.sasik.gui.objects.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ru.sasik.gui.actionlisteners.MenuSolverActionListener;
import ru.sasik.gui.objects.IMainFrame;

public class MainMenu extends JMenuBar {

	private static final long serialVersionUID = 7315824184809695830L;
	private IMainFrame mainFrame;
	private ActionListener fileChooserAction;
	private ActionListener solverActionListener;

	public MainMenu(IMainFrame frame) {
		mainFrame = frame;
		initActions();
		initComponents();
	}

	private void initComponents() {
		initFileMenu();
		initEditMenu();
		initSolverMenu();
	}
	
	public void initActions() {
		fileChooserAction = new FileChooserAction(mainFrame);
		solverActionListener = new MenuSolverActionListener();
	}
	
	public void initFileMenu() {
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
	}
	
	public void initEditMenu() {
		JMenu menu = new JMenu("Edit");

		JMenuItem itm = new JMenuItem("copy");
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
	
	public void initSolverMenu() {
		JMenu menu = new JMenu("Solver");

		JMenuItem itm = new JMenuItem("Run");
		itm.addActionListener(solverActionListener);
		menu.add(itm);

		itm = new JMenuItem("List of Solvers");
		itm.addActionListener(solverActionListener);
		itm.setActionCommand("List");
		menu.add(itm);
		
		add(menu);
	}
	
	

}
