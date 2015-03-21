package ru.sasik.gui.objects;

import javax.swing.JToolBar;

import ru.sasik.gui.objects.frame.StatusBar;
import ru.sasik.solver.Solver;

public interface IMainFrame {

	public JToolBar getToolbar();

	public StatusBar getStatusbar();

	public ICanvas getCanvas();
	
	public Solver getSelectedSolver();
	
	public void setSelectedSolver(Solver selectedSolver);

}
