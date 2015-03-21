package ru.sasik.gui.objects;

import java.util.ArrayList;

import javax.swing.JToolBar;

import ru.sasik.gui.objects.frame.StatusBar;
import ru.sasik.solver.Solver;

public interface IMainFrame {

	public JToolBar getToolbar();

	public StatusBar getStatusbar();

	public ICanvas getCanvas();
	
	public ArrayList<Solver> getSolvers();
	
	public void addSolver(Solver solver);
	
	public Solver getSelectedSolver();
	
	public void setSelectedSolver(Solver selectedSolver);
	
	public void setFilePathToOutput(String filePathToOutput);
	
	public String getFilePathToOutput();
	
	public void setFilePathToInput(String filePathToInput);
	
	public String getFilePathToInput();
	
	public String getDebugInfo();

}
