package ru.sasik.gui.simple;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import ru.sasik.datafile.DefaultDataFile;
import ru.sasik.helper.AdditionFunctions;

public class FileChooserAction implements ActionListener {

	private final JTextArea area;
	
	private JFrame frame;
	
	private ICanvas canvasPanel;
	
	private DefaultDataFile dataFile;
	
	
	public FileChooserAction(JTextArea area, JFrame frame, DefaultDataFile dataFile, ICanvas canvasPanel) {
		this.area = area;
		this.frame = frame;
		this.dataFile = dataFile;
		this.canvasPanel = canvasPanel;
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
			System.out.println("FileChooserAction.actionPerformed() \"" + commandName.toLowerCase() + "\"");
			System.out.println(ret + " " + JFileChooser.APPROVE_OPTION);
			if (ret == JFileChooser.APPROVE_OPTION) {
				if (commandName.equals("open") ) {
					dataFile = new DefaultDataFile();
					dataFile.openFromFile(file);
					canvasPanel.setDataFile(dataFile);
					String text = AdditionFunctions.readFile(file);
					//					System.out.println(area);
					area.setText(text);
					frame.pack();
				} else
					if (commandName.equals("save")) {
						System.out.println(fileopen.getSelectedFile().getPath());
						AdditionFunctions.writeFile(fileopen.getSelectedFile().getPath(), dataFile.saveToFile());
					}
			}
		}

	}
}
