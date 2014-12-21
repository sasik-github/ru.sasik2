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
	private Color color = Color.RED;

	public ShapeComponent(ICanvas canvas, String shapeName) {
		_canvas = canvas;
		_shapeName = shapeName;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		IShape shape = _canvas.getShape(_shapeName);
		g2d.setColor(getColor());
		// System.out.println("ShapeComponent.paintComponent() w:" + getWidth()
		// + " h:" + getHeight());
		if (null == shape) {
			// close method
			return;
		}
		shape.draw(g2d, new Point(getWidth(), getHeight()));
		g2d.setBackground(Color.WHITE);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
