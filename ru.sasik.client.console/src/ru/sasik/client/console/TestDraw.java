package ru.sasik.client.console;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class TestDraw extends JFrame {

	public TestDraw() throws HeadlessException {
		setTitle("Test Draw");
		setSize(400, 500);
		ObjectToDraw obj1 = new ObjectToDraw(100, 150);
		ObjectToDraw obj2 = new ObjectToDraw(150, 150);
		ObjectToDraw obj3 = new ObjectToDraw(150, 100);
		add(obj1);
		add(obj2);
		add(obj3);
		setVisible(true);
		pack();
	}
	
	
}
