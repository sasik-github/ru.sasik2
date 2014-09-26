package ru.sasik.gui.simple;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import ru.sasik.datafile.DefaultDataFile;
import ru.sasik.datafile.Point;

public class CanvasPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 703560890112489533L;

	private static Integer CONVERTER = 70;

	private static int X_ORIGIN = 2 * CONVERTER;

	private static int Y_ORIGIN = 2 * CONVERTER;

	private static int X_RADIUS = 3;

	private static int Y_RADIUS = 3;

	private static int ORIGIN_LENGTH = CONVERTER;

	private static int ORIGIN_ARROW_10 = 10;

	private static int ORIGIN_ARROW_5 = 5;

	private static Color DATA_COLOR = Color.red;

	private static Color ORIGIN_COLOR = Color.blue;

	private static int Y_REVERSE = -1;

	private DefaultDataFile dataFile;

	private static Double DX = 0.0; 

	private static Double DY = 0.0;


	public CanvasPanel(final StatusBar statusBar) {
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				statusBar.setText("X: " + ((e.getX() - X_ORIGIN) / (float) CONVERTER)  + " Y: " + ((Y_REVERSE * (e.getY() - Y_ORIGIN)) / (float) CONVERTER));
				
			}

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void paintCoord(final Graphics2D g2d) {
		g2d.setStroke(new BasicStroke());
		g2d.setColor(ORIGIN_COLOR);
		//OX 
		g2d.drawLine(X_ORIGIN,
				Y_ORIGIN,
				X_ORIGIN + ORIGIN_LENGTH,
				Y_ORIGIN
		);
		g2d.drawLine(X_ORIGIN + ORIGIN_LENGTH,
				Y_ORIGIN,
				X_ORIGIN + ORIGIN_LENGTH - ORIGIN_ARROW_10,
				Y_ORIGIN + ORIGIN_ARROW_5
		);
		g2d.drawLine(X_ORIGIN + ORIGIN_LENGTH,
				Y_ORIGIN,
				X_ORIGIN + ORIGIN_LENGTH - ORIGIN_ARROW_10,
				Y_ORIGIN - ORIGIN_ARROW_5
		);
		//OY
		g2d.drawLine(X_ORIGIN,
				Y_ORIGIN,
				X_ORIGIN,
				Y_ORIGIN + ORIGIN_LENGTH * Y_REVERSE
		);
		g2d.drawLine(X_ORIGIN,
				Y_ORIGIN + ORIGIN_LENGTH * Y_REVERSE,
				X_ORIGIN + ORIGIN_ARROW_5,
				Y_ORIGIN + (ORIGIN_LENGTH - ORIGIN_ARROW_10) * Y_REVERSE
		);
		g2d.drawLine(X_ORIGIN,
				Y_ORIGIN + ORIGIN_LENGTH * Y_REVERSE,
				X_ORIGIN - ORIGIN_ARROW_5,
				Y_ORIGIN + (ORIGIN_LENGTH -ORIGIN_ARROW_10) *  Y_REVERSE
		);
	}
	
	private void paintCoordGrid(final Graphics2D g2d) {
		
		int canvasHeight = getSize().height;
		int canvasWidth = getSize().width;
		g2d.setStroke(new BasicStroke(0.1f));
		g2d.setColor(Color.black);
		// start drawing grid from beginning to left and down
		//this is horiz
		for (int i = Y_ORIGIN; i < canvasHeight; i += CONVERTER) {
			g2d.drawLine(0, i, canvasWidth, i);
		}
		//this is vert
		for (int i = X_ORIGIN; i < canvasWidth; i += CONVERTER) {
			g2d.drawLine(i, 0, i, canvasHeight);
		} 
		// drawing grid from beginning to right and top
		// this is horiz
		for (int i = Y_ORIGIN; i > 0; i -= CONVERTER) {
			g2d.drawLine(0, i, canvasWidth, i);
		}
//		// this is vert
		for (int i = X_ORIGIN; i > 0; i -= CONVERTER) {
			g2d.drawLine(i, 0, i, canvasHeight);
		}
		
		
	}

	private void paintData(final Graphics2D g2d) {

		if (dataFile != null) {
			if (dataFile.nodes != null) {
				g2d.setStroke(new BasicStroke());
				g2d.setColor(DATA_COLOR);
		    	for (Point node : dataFile.nodes) {
			    	g2d.fillOval(
			    			(int) ((node.getX() + DX) * CONVERTER + X_ORIGIN),
			    			(int) ((node.getY() + DY) * CONVERTER * Y_REVERSE + Y_ORIGIN),
			    			X_RADIUS,
			    			Y_RADIUS
			    	);
			    }
		    	System.out.println("Nodes size" + dataFile.nodes.size());
			}
		}
	}

	@Override
	public void paint(final Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

	    Rectangle r = getBounds();
	    g2d.setBackground(Color.white);
	    g2d.clearRect(0, 0, r.width, r.height);

	    paintCoordGrid(g2d);
	    paintCoord(g2d);
	    paintData(g2d);
	    g2d.dispose();
	}

	public void setDataFile(final DefaultDataFile dataFile) {
		this.dataFile = dataFile;
		repaint();
	}

	public static int getX_ORIGIN() {
		return X_ORIGIN;
	}

	public static void setX_ORIGIN(int x_ORIGIN) {
		X_ORIGIN = x_ORIGIN;
	}

	public static int getY_ORIGIN() {
		return Y_ORIGIN;
	}
	
	public static void setY_ORIGIN(int y_ORIGIN) {
		Y_ORIGIN = y_ORIGIN;
	}

	public static int getX_RADIUS() {
		return X_RADIUS;
	}

	public static void setX_RADIUS(int x_RADIUS) {
		X_RADIUS = x_RADIUS;
	}

	public static int getY_RADIUS() {
		return Y_RADIUS;
	}

	public static void setY_RADIUS(int y_RADIUS) {
		Y_RADIUS = y_RADIUS;
	}

	public int getORIGIN_LENGTH() {
		return ORIGIN_LENGTH;
	}

	public static void setORIGIN_LENGTH(int oRIGIN_LENGTH) {
		ORIGIN_LENGTH = oRIGIN_LENGTH;
	}

	public static int getORIGIN_ARROW_10() {
		return ORIGIN_ARROW_10;
	}

	public static void setORIGIN_ARROW_10(int oRIGIN_ARROW_10) {
		ORIGIN_ARROW_10 = oRIGIN_ARROW_10;
	}

	public static int getORIGIN_ARROW_5() {
		return ORIGIN_ARROW_5;
	}

	public static void setORIGIN_ARROW_5(int oRIGIN_ARROW_5) {
		ORIGIN_ARROW_5 = oRIGIN_ARROW_5;
	}

	public static Color getDATA_COLOR() {
		return DATA_COLOR;
	}

	public static void setDATA_COLOR(Color dATA_COLOR) {
		DATA_COLOR = dATA_COLOR;
	}

	public static Color getORIGIN_COLOR() {
		return ORIGIN_COLOR;
	}

	public static void setORIGIN_COLOR(Color oRIGIN_COLOR) {
		ORIGIN_COLOR = oRIGIN_COLOR;
	}

	public static int getY_REVERSE() {
		return Y_REVERSE;
	}

	public static void setY_REVERSE(int y_REVERSE) {
		Y_REVERSE = y_REVERSE;
	}

	public static Double getDX() {
		return DX;
	}

	public static void setDX(Double dX) {
		DX = dX;
	}

	public static Double getDY() {
		return DY;
	}

	public static void setDY(Double dY) {
		DY = dY;
	}

	public static Integer getCONVERTER() {
		return CONVERTER;
	}

	public static void setCONVERTER(Integer cONVERTER) {
		CONVERTER = cONVERTER;
	}
	
	

}
