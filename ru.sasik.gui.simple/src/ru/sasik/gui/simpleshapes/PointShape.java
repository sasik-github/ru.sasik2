package ru.sasik.gui.simpleshapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import ru.sasik.gui.objects.IShape;

public class PointShape implements IShape {

	@Override
	public void draw(Graphics2D g2d, Point point) {
		int x = point.x - 12;
		int y = point.y - 12;

		g2d.setColor(Color.RED);
		g2d.drawOval(x, y, 5, 5);
		g2d.fillOval(x, y, 5, 5);
	}

}
