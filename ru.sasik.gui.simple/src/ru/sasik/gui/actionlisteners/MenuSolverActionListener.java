package ru.sasik.gui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JMenuItem;

import ru.sasik.gui.names.ConfigNames;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.gui.objects.frame.DebugInfoDialog;
import ru.sasik.gui.objects.frame.SolverListDialog;
import ru.sasik.solver.Solver;

public class MenuSolverActionListener implements ActionListener {
	
	private IMainFrame mainFrame;
	
	// who invoke the listener
	private Object menuItem;
	
	
	public MenuSolverActionListener(IMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("MenuSovlerActionListener.actionPerformed()" + e.getActionCommand());
		menuItem = e.getSource();
		getAction(e.getActionCommand());
	}
	
	private void getAction(String actionCommand) {
		if (ConfigNames.GUI_MENU_SOLVER_RUN_COMMAND == actionCommand) {
			runSolver();
		} else
		if (ConfigNames.GUI_MENU_SOLVER_LIST_COMMAND == actionCommand) {
			listSolver();
		} else 
		if (ConfigNames.GUI_MENU_SOLVER_DEBUG_COMMAND == actionCommand) {
			debugInfo();
		}
	}
	
	private void runSolver() {
		Solver solver = mainFrame.getSelectedSolver();
		try {
			solver.setFilePathToInput(mainFrame.getFilePathToInput());
			
			solver.setFilePathToOutput(mainFrame.getFilePathToOutput());
			
			solver.execute();
		} catch (NullPointerException ex) {
			System.out.println("MenuSolverActionListener.runSolver() " + ex);
			new DebugInfoDialog(mainFrame, ex.toString());
		}
	}
	
	private void listSolver() {
		SolverListDialog solvListDialog = new SolverListDialog(mainFrame, (JMenuItem) menuItem);
	}
	
	private void debugInfo() {
		DebugInfoDialog debug = new DebugInfoDialog(mainFrame, mainFrame.getDebugInfo());
	}

}
