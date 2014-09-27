package ru.sasik.client.console;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestDraw extends JFrame implements MouseMotionListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3724931234115224352L;
	private JPanel panel;
	private int BOX = 54;
	private ObjectToDraw selectedComponent = null;

	public TestDraw() throws HeadlessException {
		super("PaintFrame");
		panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(null);
		panel.setMinimumSize(new Dimension(400, 500));
		addMouseListener(this);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.CENTER);
		setTitle("Test Draw");
		setSize(400, 500);
		
		
		panel.setLayout(null);
		setVisible(true);
//		pack();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		selectedComponent.setBounds(e.getX() - BOX, e.getY() - BOX, BOX, BOX);
		System.out.println("TestDraw.mouseDragged()");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
//		selectedComponent.setBounds(e.getX() - BOX, e.getY() - BOX, BOX, BOX);
//		selectedComponent.repaint();
//		System.out.println("TestDraw.mouseMoved()");
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ObjectToDraw obj = new ObjectToDraw();
		obj.setBounds(e.getX() - BOX, e.getY() - BOX, BOX, BOX);
		panel.add(obj, 0);
		panel.validate();
		panel.repaint(obj.getBounds());
		System.out.println("TestDraw.mouseClicked()");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Component c = panel.getComponentAt(e.getPoint());
		
		if(c instanceof ObjectToDraw) {
			System.out.println("TestDraw.mousePressed()");
			selectedComponent = (ObjectToDraw) c;
			panel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			panel.addMouseMotionListener(this);
			selectedComponent.repaint();
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (selectedComponent != null) {
			panel.removeMouseMotionListener(this);
			panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			selectedComponent.setBounds(e.getX() - BOX, e.getY() - BOX, BOX, BOX);
			selectedComponent.repaint();
			selectedComponent = null;
		}
		
	}
	
	
}
