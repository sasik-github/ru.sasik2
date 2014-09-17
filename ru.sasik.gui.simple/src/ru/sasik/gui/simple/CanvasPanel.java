package ru.sasik.gui.simple;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import ru.sasik.datafile.DefaultDataFile;
import ru.sasik.datafile.Point;

public class CanvasPanel extends JPanel {
	
	private static final int X_ORIGIN = 100;

	private static final int Y_ORIGIN = 200;
	
	private static final int X_RADIUS = 2;
	
	private static final int Y_RADIUS = 2;
	
	private static final int ORIGIN_LENGTH = 50;
	
	private static final Color DATA_COLOR = Color.red;
	
	private static final Color ORIGIN_COLOR = Color.blue;
	
	private static final int Y_REVERSE = -1;

	private DefaultDataFile dataFile;
	
	private static Double DX = 0.0, DY = 0.0;
	
	private static Integer CONVERTER = 50;
	
	public CanvasPanel() {
		
		setVisible(true);
	}
	
	private void paintCoord(Graphics2D g2d) {
		g2d.setColor(ORIGIN_COLOR);
		//OX
		g2d.drawLine(X_ORIGIN, Y_ORIGIN, X_ORIGIN + ORIGIN_LENGTH, Y_ORIGIN);
		g2d.drawLine(X_ORIGIN + ORIGIN_LENGTH, Y_ORIGIN, X_ORIGIN + ORIGIN_LENGTH - 10, Y_ORIGIN + 5);
		g2d.drawLine(X_ORIGIN + ORIGIN_LENGTH, Y_ORIGIN, X_ORIGIN + ORIGIN_LENGTH - 10, Y_ORIGIN - 5);
		//OY
		g2d.drawLine(X_ORIGIN, Y_ORIGIN, X_ORIGIN, Y_ORIGIN + ORIGIN_LENGTH * Y_REVERSE);
		g2d.drawLine(X_ORIGIN, Y_ORIGIN + ORIGIN_LENGTH * Y_REVERSE, X_ORIGIN + 5, Y_ORIGIN + (ORIGIN_LENGTH - 10) * Y_REVERSE);
		g2d.drawLine(X_ORIGIN, Y_ORIGIN + ORIGIN_LENGTH * Y_REVERSE, X_ORIGIN - 5, Y_ORIGIN + (ORIGIN_LENGTH -10) *  Y_REVERSE);
	}
	
	private void paintData(Graphics2D g2d) {
		   
		try {
			g2d.setColor(DATA_COLOR);
	    	for (Point node : dataFile.nodes) {
		    	g2d.drawOval((int)((node.getX() + DX) * CONVERTER + X_ORIGIN), (int)((node.getY() + DY) * CONVERTER * Y_REVERSE+ Y_ORIGIN), X_RADIUS, Y_RADIUS);
		    }
	    	System.out.println("Nodes size" + dataFile.nodes.size());
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.err.println("Cant draw data file cause " + e);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
    	
	    Rectangle r = getBounds();
	    g2d.setBackground(Color.white);
	    g2d.clearRect(0, 0, r.width, r.height);
	    
	    paintCoord(g2d);
	    paintData(g2d);
	    g2d.dispose();
		
	}
	
	
	
	public void setDataFile(DefaultDataFile dataFile) {
		
		this.dataFile = dataFile;
		repaint();
	}
	
}
