package ru.sasik.gui.objects.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ru.sasik.gui.actionlisteners.MenuFileActionListener;
import ru.sasik.gui.actionlisteners.MenuPostprocActionListener;
import ru.sasik.gui.actionlisteners.MenuSolverActionListener;
import ru.sasik.gui.names.ConfigNames;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.solver.Solver;

public class MainMenu extends JMenuBar {

	private static final long serialVersionUID = 7315824184809695830L;
	private IMainFrame mainFrame;
	private ActionListener fileChooserAction;
	private ActionListener solverActionListener;
	private ActionListener fileActionListener;
	private ActionListener postprocActionListener;

	public MainMenu(IMainFrame frame) {
		mainFrame = frame;
		initActions();
		initComponents();
	}

	private void initComponents() {
		initFileMenu();
		initEditMenu();
		initSolverMenu();
		initPostprocMenu();
	}
	
	public void initActions() {
//		fileChooserAction = new FileChooserAction(mainFrame);
		solverActionListener = new MenuSolverActionListener(mainFrame);
		fileActionListener = new MenuFileActionListener(mainFrame);
		postprocActionListener = new MenuPostprocActionListener(mainFrame);
	}
	
	public void initFileMenu() {
		JMenu menu = new JMenu(ConfigNames.GUI_MENU_FILE_FILE_NAME);
		JMenuItem itm = new JMenuItem(ConfigNames.GUI_MENU_FILE_FILE_NAME);
		itm.setActionCommand(ConfigNames.GUI_MENU_FILE_NEW_COMMAND);
		itm.addActionListener(fileActionListener);
		menu.add(itm);

		itm = new JMenuItem(ConfigNames.GUI_MENU_FILE_OPEN_NAME);
		itm.setActionCommand(ConfigNames.GUI_MENU_FILE_OPEN_COMMAND);
		itm.addActionListener(fileActionListener);
		menu.add(itm);
		
		itm = new JMenuItem("Open (AWT Dialog)");
		itm.setActionCommand(ConfigNames.GUI_MENU_FILE_OPEN2_COMMAND);
		itm.addActionListener(fileActionListener);
		menu.add(itm);

		itm = new JMenuItem(ConfigNames.GUI_MENU_FILE_SAVE_NAME);
		itm.setActionCommand(ConfigNames.GUI_MENU_FILE_SAVE_COMMAND);
		itm.addActionListener(fileActionListener);
		menu.add(itm);

		itm = new JMenuItem(ConfigNames.GUI_MENU_FILE_CLOSE_NAME);
		itm.setActionCommand(ConfigNames.GUI_MENU_FILE_CLOSE_COMMAND);
		itm.addActionListener(fileActionListener);
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
		JMenu menu = new JMenu(ConfigNames.GUI_MENU_SOLVER_SOLVER_NAME);
		
		Solver solver = mainFrame.getSelectedSolver();
		String runItemName = ConfigNames.GUI_MENU_SOLVER_RUN_NAME;
		if (null != solver) {
			runItemName += " (" + solver.name +")";
		}
		
		JMenuItem itm = new JMenuItem(runItemName);
		itm.addActionListener(solverActionListener);
		itm.setActionCommand(ConfigNames.GUI_MENU_SOLVER_RUN_COMMAND);
		menu.add(itm);

		itm = new JMenuItem(ConfigNames.GUI_MENU_SOLVER_LIST_NAME);
		itm.addActionListener(solverActionListener);
		itm.setActionCommand(ConfigNames.GUI_MENU_SOLVER_LIST_COMMAND);
		menu.add(itm);
		
		itm = new JMenuItem(ConfigNames.GUI_MENU_SOLVER_DEBUG_NAME);
		itm.addActionListener(solverActionListener);
		itm.setActionCommand(ConfigNames.GUI_MENU_SOLVER_DEBUG_COMMAND);
		menu.add(itm);
		
		add(menu);
	}
	
	public void initPostprocMenu() {
		JMenu menu = new JMenu(ConfigNames.GUI_MENU_POSTPROC_POSTPROC_NAME);
		
		JMenuItem itm = new JMenuItem(ConfigNames.GUI_MENU_POSTPROC_SHOW_NAME);
		itm.setActionCommand(ConfigNames.GUI_MENU_POSTPROC_SHOW_COMMAND);
		itm.addActionListener(postprocActionListener);
		menu.add(itm);
		
		add(menu);
	}

}
