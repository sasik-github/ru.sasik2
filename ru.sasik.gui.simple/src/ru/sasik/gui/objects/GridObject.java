package ru.sasik.gui.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;

public class GridObject {
	
	private Component component;
	
	public GridObject(Component whereDrawGrid) {
		component = whereDrawGrid;
	}
	
	public void draw(Graphics2D g2d) {
		int canvasHeight = component.getSize().height;
		int canvasWidth = component.getSize().width;
		g2d.setStroke(new BasicStroke(0.1f));
		g2d.setColor(Color.gray);
		// start drawing grid from beginning to left and down
		// this is horiz
		for (int i = OriginObject.Y_ORIGIN; i < canvasHeight; i += OriginObject.CONVERTER) {
			g2d.drawLine(0, i, canvasWidth, i);
		}
		// this is vert
		for (int i = OriginObject.X_ORIGIN; i < canvasWidth; i += OriginObject.CONVERTER) {
			g2d.drawLine(i, 0, i, canvasHeight);
		}
		// drawing grid from beginning to right and top
		// this is horiz
		for (int i = OriginObject.Y_ORIGIN; i > 0; i -= OriginObject.CONVERTER) {
			g2d.drawLine(0, i, canvasWidth, i);
		}
		// // this is vert
		for (int i = OriginObject.X_ORIGIN; i > 0; i -= OriginObject.CONVERTER) {
			g2d.drawLine(i, 0, i, canvasHeight);
		}
	}
}
