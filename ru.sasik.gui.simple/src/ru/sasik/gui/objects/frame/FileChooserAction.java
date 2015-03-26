package ru.sasik.gui.objects.frame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import ru.sasik.datafile.DefaultDataFile;
import ru.sasik.gui.objects.ICanvas;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.helper.AdditionFunctions;

@Deprecated
public class FileChooserAction implements ActionListener {

//	private final JTextArea area;
	
	private IMainFrame frame;
	
	private ICanvas canvasPanel;
	
	private DefaultDataFile dataFile;
	
	public FileChooserAction(IMainFrame frame) {
//		this.area = area;
		if (frame != null) {
			this.frame = frame;
			this.canvasPanel = frame.getCanvas();
//			this.dataFile = canvasPanel.getDataFile();
		} else {
			System.out.println("FileChooserAction.FileChooserAction()");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser fileopen = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter(
				"Data files",
				"dat"
		);
		fileopen.addChoosableFileFilter(filter);
		String commandName = e.getActionCommand().toLowerCase();
		int ret = fileopen.showDialog(
				(Component) frame,
				  "open file"
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
					frame.setFilePathToInput(file.getAbsolutePath());
					frame.setFilePathToOutput(null);
					System.out.println("FileChooserAction.actionPerformed() " + file.getAbsolutePath());
					String text = AdditionFunctions.readFile(file);
					//					System.out.println(area);
//					area.setText(text);
					((JFrame )frame).pack();
					System.out.println("FileChooserAction.actionPerformed() \"" + commandName.toLowerCase() + "\"");
				} else
					if (commandName.equals("save")) {
						System.out.println(fileopen.getSelectedFile().getPath());
						AdditionFunctions.writeFile(fileopen.getSelectedFile().getPath(), dataFile.saveToFile());
					}
			}
		}

	}
}
