package ru.sasik.gui.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ru.sasik.gui.names.ConfigNames;

public class MenuSolverActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("MenuSovlerActionListener.actionPerformed()" + e.getActionCommand());
		getAction(e.getActionCommand());
	}
	
	private void getAction(String actionCommand) {
		if (ConfigNames.GUI_MENU_SOLVER_RUN_COMMAND == actionCommand) {
			
		} else
		if (ConfigNames.GUI_MENU_SOLVER_LIST_COMMAND == actionCommand) {
			
		}
	}
	
	private void runSolver() {
		
	}
	
	private void listSolver() {
		
		ArrayList<String> solversPaths = new ArrayList<String>();
		
		
	}

}
