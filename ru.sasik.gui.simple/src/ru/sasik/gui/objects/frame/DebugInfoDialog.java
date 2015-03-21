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

import ru.sasik.gui.names.ConfigNames;
import ru.sasik.gui.objects.IMainFrame;
import ru.sasik.gui.objects.MainFrame;
import ru.sasik.solver.Solver;

public class DebugInfoDialog extends JDialog implements ActionListener {
	
	private JFrame mainFrame;
	private JPanel panel;

	public DebugInfoDialog(IMainFrame frame) {
		super();
		this.mainFrame = (JFrame) frame;
		
		this.setTitle("Debug Info");
		panel = new JPanel();
//		panel.sets
		
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
		
		System.out.println(frame.getDebugInfo());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		
	}
}
