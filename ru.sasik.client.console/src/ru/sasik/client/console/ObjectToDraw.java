package ru.sasik.client.console;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.geom.GeneralPath;

import javax.swing.JComponent;

import org.w3c.dom.events.MouseEvent;

public class ObjectToDraw extends JComponent implements MouseListener{
	
	private static final long serialVersionUID = -2542118036219574503L;
	
//	private int x , y;
	
	public ObjectToDraw() {
		
		
	}	

	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		
		Graphics2D g2d = (Graphics2D) arg0;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = getWidth() / 2 - 25;
	    int y = getHeight() / 2 - 25;
	    GradientPaint gradient = new GradientPaint(
	      x, y, Color.YELLOW, x + 50, y, Color.WHITE);
	    g2d.setPaint(gradient);
	    int[] xcoords = { x + 10, x, x + 50, x + 40 };
	    int[] ycoords = { y, y + 50, y + 50, y };
	    GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xcoords.length);
	    polygon.moveTo(x + 25, y);
	    for (int i = 0; i < xcoords.length; i++) {
	      polygon.lineTo(xcoords[i], ycoords[i]);
	    }
	    polygon.closePath();
	    g2d.fill(polygon);
	    BasicStroke wideStroke = new BasicStroke(2.0f);
	    g2d.setColor(Color.black);
	    g2d.setStroke(wideStroke);
	    g2d.draw(polygon);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
