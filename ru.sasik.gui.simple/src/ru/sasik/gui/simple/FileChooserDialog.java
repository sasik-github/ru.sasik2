package ru.sasik.gui.simple;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserDialog extends JFrame {

		private static final int FOR_BORDER = 10;

		private static final int FRAME_HEIGHT = 400;

		private static final int FRAME_WIDTH = 300;

		private JPanel panel;

		private JTextArea area;

		public FileChooserDialog() {
			initUI();
		}

		public final void initUI() {
			panel = new JPanel();
			panel.setLayout(new BorderLayout());
			ImageIcon open = new ImageIcon("");

			JToolBar toolBar = new JToolBar();
			JButton openb = new JButton(open);

			openb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(final ActionEvent arg0) {
					JFileChooser fileopen = new JFileChooser();
					FileFilter filter = new FileNameExtensionFilter(
							"c files",
							"c"
					);
					fileopen.addChoosableFileFilter(filter);

					int ret = fileopen.showDialog(
							panel,
							"Open file"
					);

					if (ret == JFileChooser.APPROVE_OPTION) {
						File file = fileopen.getSelectedFile();
						String text = readFile(file);
						area.setText(text);
					}
				}
			});

			toolBar.add(openb);

			area = new JTextArea();
			area.setBorder(
					BorderFactory.createEmptyBorder(
							FOR_BORDER,
							FOR_BORDER,
							FOR_BORDER,
							FOR_BORDER
					)
			);

			JScrollPane pane = new JScrollPane();
			pane.getViewport().add(area);

			panel.setBorder(
					BorderFactory.createEmptyBorder(
							FOR_BORDER,
							FOR_BORDER,
							FOR_BORDER,
							FOR_BORDER
					)
			);
			panel.add(pane);
			add(panel);

			add(toolBar, BorderLayout.NORTH);

			setTitle("FileChooserDialog");
			setSize(FRAME_WIDTH, FRAME_HEIGHT);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

		public String readFile(final File file) {
			StringBuffer fileBuffer = null;
			String fileString = null;
			String line = null;

			try {
				FileReader in = new FileReader(file);
				BufferedReader brd = new BufferedReader(in);
				fileBuffer = new StringBuffer();

				while ((line = brd.readLine()) != null) {
					fileBuffer.append(line).append(
							System.getProperty("line.separator")
							);
				}
				in.close();
				fileString = fileBuffer.toString();
			} catch (IOException e) {
				System.out.println("FileChooserDialog exception " + e);
				return null;
			}
			return fileString;
		}
}
