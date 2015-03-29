package ru.sasik.solver;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.CORBA.portable.ApplicationException;

public class Solver {

//	public String solverFileName;
	
	public String name;
	
	private String os_env = "linux";

	private String filePathToSolver;
	
	private String filePathToInput;
	
	private String filePathToOutput;


	public Solver(String name) {
		this.name = name;
	}
	
	public Solver(String name, String filepath) {
		this.name = name;
		this.filePathToSolver = filepath;
	}
	
	/**
	 * передаем список команд на выполнение, первая комманда в листе, это исполняемый файл
	 * вместе с путем до него, остальные элементы, это параметры к команде
	 * @param commands
	 * @return
	 */
	public String execute() {
		
		
		System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		List<String> commands = new ArrayList<String>();
		
		// пример передаваемого списка
//			commands.add(System.getProperty("user.dir") + "/solverData/test.exe");
		
		if (System.getProperty("os.name").toLowerCase() == "linux") 
			commands.add("wine");
		commands.add(getFilePathToSolver());
		commands.add(getFilePathToInput());
		commands.add(getFilePathToOutput());
		
		// проверка на операционную систему
		// если солвер ехе то надо запускать через вайн
//		if (os_env == "linux") {
//			Path p = Paths.get(commands.get(0));
//			String file = p.getFileName().toString();
//			
//			String pathTofile = p.getParent().toString();
//			
////			commands.set(0, "wine");
////			commands.set(1, "start");
////			commands.set(2, "/unix");
////			commands.add(pathTofile + "/" + file);
////			commands.add(p.toString());
//		}
		
		try {
			
			Process p = new ProcessBuilder(commands).start();
			inheritIO(p.getInputStream(), System.out);
		    inheritIO(p.getErrorStream(), System.err);
		    
		} catch (IOException e) {
//			System.out.println(p.getInputStream());
			System.out.println("Solver.execute()" + e);
//			e.printStackTrace();
		}
		return null;
		
	}
	
	
	//for output information after execution
	private static void inheritIO(final InputStream src, final PrintStream dest) {
	    new Thread(new Runnable() {
	        public void run() {
	            Scanner sc = new Scanner(src);
	            while (sc.hasNextLine()) {
	                dest.println(sc.nextLine());
	            }
	        }
	    }).start();
	}
	
	@Override
		public String toString() {
			return getFilePathToSolver() + " " + getFilePathToInput() + " " + getFilePathToOutput();
		}

	public String getFilePathToSolver() {
		return filePathToSolver;
	}

	public void setFilePathToSolver(String filePathToSolver) {
		this.filePathToSolver = filePathToSolver;
	}

	public String getFilePathToInput() {
		return filePathToInput;
	}

	public void setFilePathToInput(String filePathToInput) {
		this.filePathToInput = filePathToInput;
	}

	public String getFilePathToOutput() {
		return filePathToOutput;
	}

	public void setFilePathToOutput(String filePathToOutput) {
		this.filePathToOutput = filePathToOutput;
	}
}

