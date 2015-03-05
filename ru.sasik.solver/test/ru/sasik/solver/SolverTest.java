package ru.sasik.solver;

import java.util.ArrayList;

public class SolverTest {
	
	private static String osEnv = "linux";
	
	public static void main(String[] args) {
		Solver solv = new Solver(null);
		
		ArrayList<String> commands = new ArrayList<String>();
		
//		if(osEnv == "linux")
//			commands.add("wine");
		// file to exec
		commands.add("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/test.exe");
		// data file
		commands.add("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/SERG.DAT");
//		commands.add("solverData/SERG.DAT");
		// output file
		commands.add("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/result2.rez");
		
		
		solv.execute(commands);
	}
}
