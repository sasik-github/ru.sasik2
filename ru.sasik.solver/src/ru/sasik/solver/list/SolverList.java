package ru.sasik.solver.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ru.sasik.solver.Solver;
/**
 * реализует наблюдатель, что бы при изменения списка солверов, изменялись вьюхи
 * 
 * @author sasik
 *
 */
public class SolverList extends Observable {
	
	private List<Solver> solverList;
	
	public SolverList() {
		super();
		setSolverList(new ArrayList<Solver>());
	}

	public List<Solver> getSolverList() {
		return solverList;
	}

	public void setSolverList(List<Solver> solverList) {
		this.solverList = solverList;
		notifyObservers();
	}
	
	public void addSolver(Solver solver) {
		System.out.println("SolverList.addSolver()");
		solverList.add(solver);
		setChanged();
		notifyObservers();
		
	}
}
