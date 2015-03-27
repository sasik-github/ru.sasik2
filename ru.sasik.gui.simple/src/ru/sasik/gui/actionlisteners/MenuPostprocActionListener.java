package ru.sasik.gui.actionlisteners;

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
		case ConfigNames.GUI_MENU_POSTPROC_SHOW_COMMAND:
			showResults();
			break;

		default:
			break;
		}
		
	}

	private void showResults() {
		String filePathToOutput = mainFrame.getFilePathToOutput();
		SolutionDataFile results = new SolutionDataFile();
		results.open(new File(filePathToOutput));
		
		mainFrame.getPostprocState().setSolutionDataFile(results);
		new DebugInfoDialog(mainFrame, results.getRezFile().toString());
	}

}
