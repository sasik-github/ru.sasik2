package ru.sasik.gui.objects;

import javax.swing.JFrame;

import ru.sasik.datafile.DefaultDataFile;

public interface ICanvas {

	public void setMainFrame(JFrame frame);

	public IShape getShape(String shapeName);
	
	public void addShape(String shapeName, IShape shape);
	
	public void setDataFile(DefaultDataFile data);

}
