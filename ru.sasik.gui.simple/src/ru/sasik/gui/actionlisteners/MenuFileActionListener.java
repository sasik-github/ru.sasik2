package ru.sasik.gui.actionlisteners;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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
		case ConfigNames.GUI_MENU_FILE_OPEN2_COMMAND:
			open2DataFile();
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

	private void open2DataFile() {
		String fileName = invokeSwtDialog(mainFrame, "Choose a dat file", FileDialog.LOAD, ".dat");
		File file = new File(fileName);
		if (file.exists()) {
			DefaultDataFile dataFile = new DefaultDataFile();
			dataFile.openFromFile(file);
			mainFrame.getCanvas().setDataFile(dataFile);
			mainFrame.setFilePathToInput(file.getAbsolutePath());
			mainFrame.setFilePathToOutput(null);
		}
	}

	private void newDataFile() {
		
	}

	private void openDataFile() {
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
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
//						  "open file"
						);
				File file = fileopen.getSelectedFile();
				if (file.exists()) {
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
//							area.setText(text);
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
		};
		
		SwingUtilities.invokeLater(runnable);
	}

	private void saveDataFile() {
		throw new UnsupportedOperationException();
	}

	private void closeApplication() {
		((JFrame)mainFrame).dispose();
	}

}
