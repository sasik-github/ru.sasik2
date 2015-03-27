package ru.sasik.postproc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ru.sasik.datafile.SolutionDataFile;

public class PostprocCanvasTest {
	
	public static void main(String[] args) {
		createPostprocGui();
	}

	private static void createPostprocGui() {
		PostprocCanvas postprocCanvas = new PostprocCanvas();
		PostprocState postprocState = new PostprocState();
		SolutionDataFile solutionDataFile = new SolutionDataFile();
		solutionDataFile.open(new File("/home/sasik/workspace/ru.sasik2/ru.sasik.solver/solverData/SERG.DAT.output.rez"));
		postprocState.setSolutionDataFile(solutionDataFile);
		postprocCanvas.setPostprocState(postprocState );
		
		
		JFrame frame = new JFrame();
		
		postprocCanvas.setBorder(BorderFactory.createLineBorder(Color.red));
		JScrollPane pane = new JScrollPane();
		pane.getViewport().add(postprocCanvas);
		frame.add(pane, BorderLayout.CENTER);
		PostprocControllerPanel postprocControllerPanel = new PostprocControllerPanel(postprocState, postprocCanvas);
		frame.add(postprocControllerPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.pack();
		
	}
	
	
	
}
