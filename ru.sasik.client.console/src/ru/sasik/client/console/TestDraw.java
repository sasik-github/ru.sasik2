package ru.sasik.client.console;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestDraw extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3724931234115224352L;
	private JPanel panel;

	public TestDraw() throws HeadlessException {
		super("PaintFrame");
		panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(null);
		panel.setMinimumSize(new Dimension(400, 500));
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.CENTER);
		setTitle("Test Draw");
		setSize(400, 500);
//		setLayout(null);
//		ObjectToDraw obj1 = new ObjectToDraw(100, 150, this);
//		ObjectToDraw obj2 = new ObjectToDraw(150, 150, this);
//		ObjectToDraw obj3 = new ObjectToDraw(150, 100, this);
//		panel.add(obj1, 0);
//		panel.add(obj2, 0);
//		panel.add(obj3);
		panel.validate();
//		panel.repaint(obj1.getBounds());
		
		repaint();
		setVisible(true);
//		pack();
	}
	
	
}
