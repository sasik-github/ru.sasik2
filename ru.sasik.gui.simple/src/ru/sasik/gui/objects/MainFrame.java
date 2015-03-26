package ru.sasik.gui.objects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import ru.sasik.datafile.DefaultDataFile;
import ru.sasik.gui.objects.frame.MainMenu;
import ru.sasik.gui.objects.frame.MainToolbar;
import ru.sasik.gui.objects.frame.StatusBar;
import ru.sasik.solver.Solver;

public class MainFrame extends JFrame implements IMainFrame {

	private static final long serialVersionUID = -3012101084369765594L;

	private static final int WIDTH = 640;

	private static final int HEIGHT = 700;

	private static final String FRAME_TITLE = "ru.sasik.gui";

	private Canvas canvas;

	private JToolBar toolbar;

	private MainMenu menubar;

	private StatusBar stausBar;
	
	private Solver selectedSolver;
	
	private String filePathToInput;
	
	private String filePathToOutput;

	// containers for all workspace objects
	// used for BorderLayout if you want to add
	// several object to BorderLayour.North or other space
	private Container mainContentPane;
	private JPanel northContent;
	private JPanel middleContent;
	private JPanel southContent;

	private ArrayList<Solver> solverList;

	public MainFrame() {

		northContent = new JPanel();
		FlowLayout northFlowLayout = new FlowLayout();
		middleContent = new JPanel();
		middleContent.setLayout(new FlowLayout());
		southContent = new JPanel();

		mainContentPane = getContentPane();
		mainContentPane.setLayout(new BorderLayout());
		mainContentPane.add(northContent, BorderLayout.NORTH);
		mainContentPane.add(middleContent, BorderLayout.CENTER);
		mainContentPane.add(southContent, BorderLayout.SOUTH);

		northContent.setLayout(northFlowLayout);
		northFlowLayout.setAlignment(FlowLayout.LEFT);

		initComponents();
		setTitle(FRAME_TITLE);
		pack();
		setVisible(true);
	}

	private void initComponents() {
		createToolbarContent();
		createWorkspaceContent();
		createFrameContent();
		createStatusbarContent();
		createMenuContent();
		
		Solver solv = new Solver("SergSolver");
		solv.setFilePathToSolver("/home/sasik/EclipseWorkspace/ru.sasik2/ru.sasik.solver/solverData/test.exe");
		
		addSolver(solv);
	}

	private void createStatusbarContent() {
		stausBar = new ru.sasik.gui.objects.frame.StatusBar();
		southContent.add(stausBar);

	}

	private void createToolbarContent() {
		toolbar = new MainToolbar();
		northContent.add(toolbar);
	}

	private void createFrameContent() {
		//

	}

	private void createWorkspaceContent() {
		canvas = new Canvas();
		canvas.setBorder(BorderFactory.createLineBorder(Color.red));
		JScrollPane pane = new JScrollPane();
		pane.getViewport().add(canvas);
		add(pane, BorderLayout.CENTER);
		
		filePathToInput = "/home/sasik/Dropbox/11111/Akord/SERG.DAT"; 
		
		File file = new File(filePathToInput);
		
//		test write function
//		AdditionFunctions.writeFile("/home/sasik/Dropbox/11111/Akord/sasik.DAT", AdditionFunctions.readFile(file));
		if (file.exists()) {
			DefaultDataFile data = new DefaultDataFile();
			data.openFromFile(file);
			data.saveToFile();
			canvas.setDataFile(data);
		}
		
		CanvasMouseListener canvasMouseListener = new CanvasMouseListener(canvas);
		canvas.addMouseListener(canvasMouseListener);
	}

	private void createMenuContent() {
		menubar = new MainMenu(this);
		setJMenuBar(menubar);
	}

	@Override
	public JToolBar getToolbar() {
		return toolbar;
	}

	@Override
	public StatusBar getStatusbar() {
		return stausBar;
	}

	@Override
	public ICanvas getCanvas() {
		return canvas;
	}

	@Override
	public Solver getSelectedSolver() {
		return selectedSolver;
	}

	public void setSelectedSolver(Solver selectedSolver) {
		selectedSolver.setFilePathToInput(getFilePathToInput());
		selectedSolver.setFilePathToOutput(getFilePathToOutput());
		this.selectedSolver = selectedSolver;
	}

	public String getFilePathToInput() {
		return filePathToInput;
	}

	public void setFilePathToInput(String filePathToInput) {
		this.filePathToInput = filePathToInput;
	}

	public String getFilePathToOutput() {
		if (filePathToOutput == null) 
			filePathToOutput = filePathToInput + ".output.rez";
		return filePathToOutput;
	}

	public void setFilePathToOutput(String filePathToOutput) {
		this.filePathToOutput = filePathToOutput;
	}

	@Override
	public String getDebugInfo() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Input file: " + getFilePathToInput() + System.lineSeparator());
		sb.append("Outpu file: " + getFilePathToOutput() + System.lineSeparator());
		sb.append("Solver file: " + selectedSolver.name + " " + selectedSolver + System.lineSeparator());
		return sb.toString();
	}

	@Override
	public ArrayList<Solver> getSolvers() {
		if (solverList == null) {
			solverList = new ArrayList<Solver>();
		}
		return solverList;
	}

	@Override
	public void addSolver(Solver solver) {
		ArrayList<Solver> solvers = getSolvers();
		solvers.add(solver);
	}

}
