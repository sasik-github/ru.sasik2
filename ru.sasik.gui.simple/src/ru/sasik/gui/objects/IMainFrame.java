package ru.sasik.gui.objects;

import java.util.ArrayList;

import javax.swing.JToolBar;

import ru.sasik.gui.objects.frame.StatusBar;
import ru.sasik.postproc.PostprocState;
import ru.sasik.solver.Solver;
import ru.sasik.solver.list.SolverList;

public interface IMainFrame {

	public JToolBar getToolbar();

	public StatusBar getStatusbar();

	public ICanvas getCanvas();
	
	public SolverList getSolvers();
	
	public void addSolver(Solver solver);
	
	public Solver getSelectedSolver();
	
	public void setSelectedSolver(Solver selectedSolver);
	
	public void setFilePathToOutput(String filePathToOutput);
	
	public String getFilePathToOutput();
	
	public void setFilePathToInput(String filePathToInput);
	
	public String getFilePathToInput();
	
	public String getDebugInfo();
	
	public void setPostprocState(PostprocState postprocState);
	
	public PostprocState getPostprocState();

}
