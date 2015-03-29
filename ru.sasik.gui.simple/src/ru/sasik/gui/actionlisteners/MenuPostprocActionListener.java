package ru.sasik.gui.actionlisteners;

import java.awt.FileDialog;
import java.io.File;

import ru.sasik.datafile.SolutionDataFile;
import ru.sasik.gui.names.ConfigNames;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.gui.objects.frame.DebugInfoDialog;

public class MenuPostprocActionListener extends MenuActionListenerAbstract{

	public MenuPostprocActionListener(IMainFrame mainFrame) {
		super(mainFrame);

	}

	protected void getAction(String actionCommand) {
		switch (actionCommand) {
		case ConfigNames.GUI_MENU_POSTPROC_OPEN_COMMAND:
			openResultFileDialog();
			break;
		case ConfigNames.GUI_MENU_POSTPROC_SHOW_COMMAND:
			showResults();
			break;
		default:
			throw new UnsupportedOperationException(actionCommand);
		}
		
	}

	private void openResultFileDialog() {
		String filename = invokeSwtDialog(mainFrame, "Open file to visualize", FileDialog.LOAD, ".rez");
		
		mainFrame.setFilePathToOutput(filename);
	}

	private void showResults() {
		String filePathToOutput = mainFrame.getFilePathToOutput();
		SolutionDataFile results = new SolutionDataFile();
		results.open(new File(filePathToOutput));
		
		mainFrame.getPostprocState().setSolutionDataFile(results);
		new DebugInfoDialog(mainFrame, results.getRezFile().toString());
	}

}
