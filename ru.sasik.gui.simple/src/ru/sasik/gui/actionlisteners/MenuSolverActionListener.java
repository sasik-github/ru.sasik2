package ru.sasik.gui.actionlisteners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import ru.sasik.gui.names.ConfigNames;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.gui.objects.frame.DebugInfoDialog;
import ru.sasik.gui.objects.frame.SolverListDialog;
import ru.sasik.solver.Solver;

public class MenuSolverActionListener implements ActionListener {
	
	private IMainFrame mainFrame;
	
	// who invoke the listener
	private Object menuItem;

	private ActionEvent event;
	
	public MenuSolverActionListener(IMainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		event = e;
		System.out.println("MenuSovlerActionListener.actionPerformed()" + e.getActionCommand());
		menuItem = e.getSource();
		getAction(e.getActionCommand());
	}
	
	private void getAction(String actionCommand) {
		switch (actionCommand) {
		case ConfigNames.GUI_MENU_SOLVER_RUN_COMMAND:
			runSolver();
			break;
		case ConfigNames.GUI_MENU_SOLVER_LIST_COMMAND:
			listSolver();
			break;
		case ConfigNames.GUI_MENU_SOLVER_DEBUG_COMMAND:
			debugInfo();
			break;
		case ConfigNames.GUI_MENU_SOLVER_LIST_ADDSOLVER_COMMAND:
			addSolver();
			break;
		default:
			break;
		}
	}
	
	private void addSolver() {
		JFileChooser solverChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Only executable binaryies files", "exe", "com");
		solverChooser.setFileFilter(filter);
		int returnVal = solverChooser.showOpenDialog((Component) mainFrame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File selectedFile = solverChooser.getSelectedFile();
			Solver newSolver = new Solver(selectedFile.getName());
			newSolver.setFilePathToSolver(selectedFile.getAbsolutePath());
			mainFrame.addSolver(newSolver);
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
