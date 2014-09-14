package ru.sasik.gui.simple;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserAction implements ActionListener {

	private JTextArea area;
	
	private Object frame;
	
	public FileChooserAction(JTextArea area, Object frame) {
		this.area = area;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser fileopen = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter(
				"c files",
				"c"
		);
		fileopen.addChoosableFileFilter(filter);

		int ret = fileopen.showDialog(
				(Component) frame,
				"Open file"
		);

		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fileopen.getSelectedFile();
			String text = AdditionFunctions.readFile(file);
			System.out.println(area);
			area.setText(text);
		}

	}
}
