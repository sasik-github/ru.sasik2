package ru.sasik.gui.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JComponent;

public class ShapeComponent extends JComponent {

	private static final long serialVersionUID = 8131137653298849378L;
	private String _shapeName;
	private ICanvas _canvas;
	public int displacmentX = 35;

	public ShapeComponent(ICanvas canvas, String shapeName) {
		_canvas = canvas;
		_shapeName = shapeName;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		IShape shape = _canvas.getShape(_shapeName);
		System.out.println("ShapeComponent.paintComponent() w:" + getWidth()
				+ " h:" + getHeight());
		shape.draw(g2d, new Point(getWidth(), getHeight()));
		g2d.setBackground(Color.WHITE);
	}
}
