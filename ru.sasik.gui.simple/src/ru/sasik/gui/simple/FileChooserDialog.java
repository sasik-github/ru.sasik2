package ru.sasik.gui.simple;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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

import ru.sasik.helper.AdditionFunctions;


@Deprecated
public class FileChooserDialog extends JFrame {

	private static final long serialVersionUID = -2418283983706021047L;

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
						String text = AdditionFunctions.readFile(file);
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
}
