package ru.sasik.gui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;

import ru.sasik.gui.names.ConfigNames;
import ru.sasik.gui.objects.IMainFrame;
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
		getAction(e.getActionCommand());
		
		menuItem = e.getSource();
	}
	
	private void getAction(String actionCommand) {
		if (ConfigNames.GUI_MENU_SOLVER_RUN_COMMAND == actionCommand) {
			runSolver();
		} else
		if (ConfigNames.GUI_MENU_SOLVER_LIST_COMMAND == actionCommand) {
			listSolver();
		}
	}
	
	private void runSolver() {
		
	}
	
	private void listSolver() {
		SolverListDialog solvListDialog = new SolverListDialog(mainFrame);
		
		solvListDialog.setWhoInvoke(menuItem);
	}

}
