package ru.sasik.solver;

import java.util.ArrayList;

public class SolverTest {
	
	private static String osEnv = "linux";
	
	public static void main(String[] args) {
		Solver solv = new Solver("SergSolver");
		solv.setFilePathToSolver("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/test.exe");
		solv.setFilePathToInput("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/SERG.DAT");
		solv.setFilePathToOutput("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/result2.rez");
		
//		ArrayList<String> commands = new ArrayList<String>();
		
////		if(osEnv == "linux")
////			commands.add("wine");
//		// file to exec
//		commands.add("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/test.exe");
//		// data file
//		commands.add("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/SERG.DAT");
////		commands.add("solverData/SERG.DAT");
//		// output file
//		commands.add("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/result2.rez");
		
		Solver solv2 = new Solver("Serg2");
		// /home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/test.exe /home/sasik/Dropbox/11111/Akord/DMITRY.DAT /home/sasik/Dropbox/11111/Akord/DMITRY.DAT.output.rez
		solv2.setFilePathToInput("/home/sasik/Dropbox/11111/Akord/DMITRY.DAT");
		solv2.setFilePathToOutput("/home/sasik/Dropbox/11111/Akord/DMITRY.DAT.output.rez");
		solv2.setFilePathToSolver("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/test.exe");
		
		
		solv2.execute();
	}
}
