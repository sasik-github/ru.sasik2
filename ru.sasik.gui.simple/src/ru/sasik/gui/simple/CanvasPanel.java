package ru.sasik.gui.simple;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import ru.sasik.datafile.DefaultDataFile;
import ru.sasik.datafile.Point;

public class CanvasPanel extends JPanel {
	
	private static final int X_ORIGIN = 300;

	private static final int Y_ORIGIN = 300;
	
	private static final int X_RADIUS = 2;
	
	private static final int Y_RADIUS = 2;

	private DefaultDataFile dataFile;
	
	private static Double DX = 0.0, DY = 0.0;
	
	private static Integer CONVERTER = 50;
	
	public CanvasPanel() {
		
		setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2= (Graphics2D) g;
    	
	    Rectangle r = getBounds();
	    g2.setBackground(Color.white);
	    g2.clearRect(0, 0, r.width, r.height);	
	    	
	    g.setColor(Color.red);
	    
	    try {
	    	for (Point node : dataFile.nodes) {
		    	g.drawOval((int)((node.getX() + DX) * CONVERTER + X_ORIGIN), (int)((node.getY() + DY) * CONVERTER + Y_ORIGIN), X_RADIUS, Y_RADIUS);
		    }
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.err.println("Cant draw data file cause " + e);
		}
	    
	    
	    System.out.println("Nodes size" + dataFile.nodes.size());
	    g.drawString("Hello, world", 20, 20);
//	    g.fillRect(60,60, 120, 120);
		
	}
	
	public void setDataFile(DefaultDataFile dataFile) {
		
		this.dataFile = dataFile;
		repaint();
	}
	
}
