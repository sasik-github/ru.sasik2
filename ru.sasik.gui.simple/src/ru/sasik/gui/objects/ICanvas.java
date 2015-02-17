package ru.sasik.gui.objects;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import ru.sasik.datafile.DefaultDataFile;

public interface ICanvas {

	public void setMainFrame(JFrame frame);

	public IShape getShape(String shapeName);
	
	public void addShape(String shapeName, IShape shape);
	
	public void setDataFile(DefaultDataFile data);
	
	public DefaultDataFile getDataFile();
	
	public Component getComponentAt(Point p);

	public void setCursor(Cursor predefinedCursor);

	public void addMouseMotionListener(MouseMotionListener canvasMouseListener);

	public void removeMouseMotionListener(
			MouseMotionListener canvasMouseListener);

	public boolean contains(int x, int y);

	public Component add(Component sc, int i);

	public void validate();

	public void repaint(Rectangle bounds);

}
