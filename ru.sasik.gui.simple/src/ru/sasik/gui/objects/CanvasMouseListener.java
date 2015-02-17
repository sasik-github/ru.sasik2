package ru.sasik.gui.objects;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CanvasMouseListener implements MouseListener, MouseMotionListener {

	private ICanvas canvas;
	private ShapeComponent m_selectedComponent;
	private String m_selected;

	public CanvasMouseListener(ICanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		m_selectedComponent.setBounds(e.getX() - m_selectedComponent.BOX / 2,
				e.getY() - m_selectedComponent.displacmentX,
				m_selectedComponent.BOX, m_selectedComponent.BOX);
		m_selectedComponent.repaint();
		canvas.validate();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		System.out.println("DrawCanvas2.mousePressed() Point = " + p);
		// p.y -= ShapeComponent.displacmentX;
		System.out.println("DrawCanvas2.mousePressed() Point  =" + p);
		Component component = canvas.getComponentAt(p);
		System.out.println("DrawCanvas2.mousePressed() " + component);
		if (component instanceof ShapeComponent) {
			m_selectedComponent = (ShapeComponent) component;
			canvas.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			canvas.addMouseMotionListener(this);
			m_selectedComponent.repaint();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("CanvasMouseListener.mouseReleased() "
				+ m_selectedComponent);
		// if (m_selected == null) {
		// return;
		// }
		if (m_selectedComponent != null) {
			if (canvas.contains(e.getX(), e.getY())) {

				ShapeComponent sc = new ShapeComponent(canvas, m_selected);
				sc.setBounds(e.getX() - m_selectedComponent.BOX / 2, e.getY()
						- sc.displacmentX, m_selectedComponent.BOX,
						m_selectedComponent.BOX);
				canvas.add(sc, 0);
				canvas.validate();
				canvas.repaint(sc.getBounds());
//				return;
			}
			canvas.removeMouseMotionListener(this);
			canvas.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			m_selectedComponent.setBounds(e.getX() - m_selectedComponent.BOX
					/ 2, e.getY() - m_selectedComponent.displacmentX,
					m_selectedComponent.BOX, m_selectedComponent.BOX);
			m_selectedComponent.repaint();
			m_selectedComponent = null;
			return;

		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
