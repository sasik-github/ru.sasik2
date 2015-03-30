package ru.sasik.gui.objects.frame;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ru.sasik.gui.actionlisteners.MenuSolverActionListener;
import ru.sasik.gui.names.ConfigNames;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.solver.Solver;
import ru.sasik.solver.list.SolverList;

public class SolverListDialog extends JDialog implements ActionListener, Observer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3567499791687523935L;

	private String selectedSolver;
	
	private JFrame mainFrame;
	
	private SolverList solvers;

	private JPanel panel;

	private JMenuItem whoInvoke;

	private JComboBox<Object> solverChoice2;
	
	public SolverListDialog(IMainFrame frame, JMenuItem menuItem) {
		super();
		this.mainFrame = (JFrame) frame;
		whoInvoke = menuItem;
		
		solvers = frame.getSolvers();
		
		this.setTitle("List of Solver");
		panel = new JPanel();
		
		panel.add(new JLabel("Choose the Solver:"));
		
		initGUI();

		JPanel actionsPanel = new JPanel();
		JButton button = new JButton(ConfigNames.GUI_OK_NAME);
		button.addActionListener(this);
		button.setActionCommand(ConfigNames.GUI_OK_COMMAND);
		actionsPanel.add(button);
		button = new JButton(ConfigNames.GUI_CANCEL_NAME);
		button.addActionListener(this);
		button.setActionCommand(ConfigNames.GUI_CANCEL_COMMAND);
		actionsPanel.add(button);
//		actionsPanel.setLayout(mgr);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		add(panel);
		panel.add(actionsPanel);
		
		setLocationRelativeTo(this.mainFrame);
		setVisible(true);
		pack();
		solvers.addObserver(this);
//		solvers.setMyObs(this);
	}

	private void initGUI() {
		solverChoice2 = new JComboBox<>();
//		panel.add(solverChoice);
		
		JButton addSolverButton = new JButton(ConfigNames.GUI_MENU_SOLVER_LIST_ADDSOLVER_NAME);
		addSolverButton.setActionCommand(ConfigNames.GUI_MENU_SOLVER_LIST_ADDSOLVER_COMMAND);
		addSolverButton.addActionListener(new MenuSolverActionListener((IMainFrame) mainFrame));
		panel.add(addSolverButton);
		
		addSolverButton = new JButton("Add Solver(AWT Dialog)");
		addSolverButton.setActionCommand(ConfigNames.GUI_MENU_SOLVER_LIST_ADDSOLVER2_COMMAND);
		addSolverButton.addActionListener(new MenuSolverActionListener((IMainFrame) mainFrame));
		panel.add(addSolverButton);
		
		panel.add(solverChoice2);

		initSolversList();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (ConfigNames.GUI_CANCEL_COMMAND == e.getActionCommand()) {
			dispose();
		}else
		if (ConfigNames.GUI_OK_COMMAND == e.getActionCommand()) {
			Solver selectedSolver = null;
			System.out.println("SolverListDialog.actionPerformed()" + solverChoice2.getSelectedItem());
			for (Solver solver : solvers.getSolverList()) {
				if (solverChoice2.getSelectedItem() == solver.name) {
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
	
	public void initSolversList() {
		solverChoice2.removeAllItems();
		for (Solver solver : solvers.getSolverList()) {
			solverChoice2.addItem(solver.name);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("SolverListDialog.update()");
		initSolversList();
		repaint();
		
	}

}
