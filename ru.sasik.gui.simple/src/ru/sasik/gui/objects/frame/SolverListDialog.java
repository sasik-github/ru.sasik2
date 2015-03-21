package ru.sasik.gui.objects.frame;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ru.sasik.gui.names.ConfigNames;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.solver.Solver;

public class SolverListDialog extends JDialog implements ActionListener{
	
	private String selectedSolver;
	
	private Choice solverChoice;
	
	private JFrame mainFrame;
	
	private ArrayList<Solver> solvers;

	private JPanel panel;

	private JMenuItem whoInvoke;
	
	public SolverListDialog(IMainFrame frame, JMenuItem menuItem) {
		super();
		this.mainFrame = (JFrame) frame;
		whoInvoke = menuItem;
		
		Solver solv = new Solver("SergSolver");
		solv.setFilePathToSolver("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/test.exe");
		solv.setFilePathToInput("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/SERG.DAT");
		solv.setFilePathToOutput("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/result2.rez");
//		
//		Solver solv2 = new Solver("DNS");
//		solv2.setFilePathToSolver("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/DNS.exe");
//		solv2.setFilePathToInput("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/DNS.DAT");
//		solv2.setFilePathToOutput("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/DNS.rez");
		
		solvers = frame.getSolvers();
		
//		solvers.add(solv);
//		solvers.add(solv2);
		
		frame.setSelectedSolver(solv);
		
		this.setTitle("Properties");
		panel = new JPanel();
//		panel.sets
		
		panel.add(new JLabel("Change properties of canvas"));
		
		initGUI();

		JButton button = new JButton(ConfigNames.GUI_OK_NAME);
		button.addActionListener(this);
		button.setActionCommand(ConfigNames.GUI_OK_COMMAND);
		panel.add(button);
		button = new JButton(ConfigNames.GUI_CANCEL_NAME);
		button.addActionListener(this);
		button.setActionCommand(ConfigNames.GUI_CANCEL_COMMAND);
		panel.add(button);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		add(panel);
		setLocationRelativeTo(this.mainFrame);
		setVisible(true);
		pack();
	}

	private void initGUI() {
		solverChoice = new Choice();
		
		for (Solver solver : solvers) {
			solverChoice.add(solver.name);
		}
		
		solverChoice.getSelectedItem();
		
		panel.add(solverChoice);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (ConfigNames.GUI_CANCEL_COMMAND == e.getActionCommand()) {
			dispose();
		}else
		if (ConfigNames.GUI_OK_COMMAND == e.getActionCommand()) {
			System.out.println("SolverListDialog.actionPerformed()" + solverChoice.getSelectedItem());
			Solver selectedSolver = null;
			for (Solver solver : solvers) {
				if (solverChoice.getSelectedItem() == solver.name) {
					selectedSolver = solver;
					((IMainFrame) mainFrame).setSelectedSolver(selectedSolver);
					String runItemName = ConfigNames.GUI_MENU_SOLVER_LIST_NAME;
					if (null != solver) {
						runItemName += " (" + selectedSolver.name +")";
					}
					System.out.println("SolverListDialog.actionPerformed()" + whoInvoke);
					whoInvoke.setText(runItemName);
					break;
				}
			}
			
			dispose();
		}
	}

	public void setWhoInvoke(Object menuItem) {
		whoInvoke = (JMenuItem) menuItem;
		
	}
}
