package ru.sasik.gui.actionlisteners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import ru.sasik.datafile.DefaultDataFile;
import ru.sasik.gui.names.ConfigNames;
import ru.sasik.gui.objects.ICanvas;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.helper.AdditionFunctions;

public class MenuFileActionListener extends MenuActionListenerAbstract {

	public MenuFileActionListener(IMainFrame mainFrame) {
		super(mainFrame); 
	}

	@Override
	protected void getAction(String actionCommand) {
		switch (actionCommand) {
		case ConfigNames.GUI_MENU_FILE_NEW_COMMAND:
			newDataFile();
			break;
		case ConfigNames.GUI_MENU_FILE_OPEN_COMMAND:
			openDataFile();
			break;
		case ConfigNames.GUI_MENU_FILE_SAVE_COMMAND:
			saveDataFile();
			break;
		
		case ConfigNames.GUI_MENU_FILE_CLOSE_COMMAND:
			closeApplication();
			break;
		default:
			break;
		}
		
	}

	private void newDataFile() {
		
		
	}

	private void openDataFile() {
		
		DefaultDataFile dataFile = null;
		ICanvas canvasPanel = mainFrame.getCanvas();

		JFileChooser fileopen = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter(
				"Data files",
				"dat"
		);
		fileopen.addChoosableFileFilter(filter);
		String commandName = event.getActionCommand().toLowerCase();
		int ret = fileopen.showOpenDialog(
				(Component) mainFrame//,
//				  "open file"
				);
		File file = fileopen.getSelectedFile();
		if (file != null) {
			System.out.println(file.getPath());
			System.out.println(ret + " " + JFileChooser.APPROVE_OPTION);
			if (ret == JFileChooser.APPROVE_OPTION) {
				if (commandName.equals("open") ) {
					dataFile = new DefaultDataFile();
					dataFile.openFromFile(file);
					canvasPanel.setDataFile(dataFile);
					mainFrame.setFilePathToInput(file.getAbsolutePath());
					mainFrame.setFilePathToOutput(null);
					System.out.println("FileChooserAction.actionPerformed() " + file.getAbsolutePath());
					String text = AdditionFunctions.readFile(file);
					//					System.out.println(area);
//					area.setText(text);
					((JFrame )mainFrame).pack();
					System.out.println("FileChooserAction.actionPerformed() \"" + commandName.toLowerCase() + "\"");
				} else
					if (commandName.equals("save")) {
						System.out.println(fileopen.getSelectedFile().getPath());
						AdditionFunctions.writeFile(fileopen.getSelectedFile().getPath(), dataFile.saveToFile());
					}
			}
		}
		
	}

	private void saveDataFile() {
		
		
	}

	private void closeApplication() {
		((JFrame)mainFrame).dispose();
	}

}
