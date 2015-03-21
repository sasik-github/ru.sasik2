package ru.sasik.gui.objects.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ru.sasik.gui.names.ConfigNames;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.gui.objects.MainFrame;
import ru.sasik.solver.Solver;

public class DebugInfoDialog extends JDialog implements ActionListener {
	
	private JFrame mainFrame;
	private JPanel panel;
	
	private String message;

	public DebugInfoDialog(IMainFrame frame, String message) {
		super();
		this.mainFrame = (JFrame) frame;
		this.message = message;
		
		this.setTitle("Debug Info");
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Change properties of canvas"));
		
		initGUI();

		JButton button = new JButton(ConfigNames.GUI_OK_NAME);
		button.addActionListener(this);
		button.setActionCommand(ConfigNames.GUI_OK_COMMAND);
		panel.add(button);
				
		add(panel);
		setLocationRelativeTo(this.mainFrame);
		setVisible(true);
		pack();
	}

	private void initGUI() {
		IMainFrame frame = (IMainFrame) mainFrame; 
		
		JTextArea textArea = new JTextArea(message);
		panel.add(textArea);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
